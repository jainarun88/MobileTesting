package com.mobileTest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.LoginPage.LoginPageObjects;
import com.LoginPage.LoginPageSevices;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mobileNew.AppConstants;
import com.mobileNew.DriverUtilities;
import com.mobileNew.ExcelUtilities;
import com.mobileNew.ExtentUtility;

import io.appium.java_client.android.AndroidDriver;

public class LoginTest {
	@Test
	public void loginPageTest(){
		AndroidDriver<WebElement> androidDriver = null;
		boolean isSeverStart = false;
		try {
			isSeverStart = DriverUtilities.startServer();
			androidDriver = DriverUtilities.initDriver(androidDriver);
		}catch(Exception serverNotStartException) {
			ExtentUtility.severFailureReport("Login Page Test", "This test is created when server is not started", LoginPageObjects.HTMLREPORT_RESULT_PATH);
		}
		if(isSeverStart) {
			testLogin(androidDriver, null, null, null, "");
		}
	}

	public void testLogin(AndroidDriver<WebElement> androidDriver, ExtentHtmlReporter htmlReporter, ExtentTest loginLog, ExtentReports extent, String moduleScriptName)	{
		if(loginLog==null){
			htmlReporter = new ExtentHtmlReporter(LoginPageObjects.HTMLREPORT_RESULT_PATH);
			extent = ExtentUtility.getExtentReportConfig(htmlReporter, extent, AppConstants.HOSTNAME, AppConstants.ENVIRONMENT, AppConstants.USERNAME_REPORT, AppConstants.DOC_TITLE, this.getClass().getSimpleName());
			loginLog = extent.createTest("Login Page Test", "This test is used to validate Login Page Test");
		}
		ExcelUtilities loginTestData = new ExcelUtilities(LoginPageObjects.LOGIN_TESTDATA_PATH);
		LoginPageSevices loginPage = new LoginPageSevices(androidDriver);
		String userName = "";
		String passWord = "";
		String sheetName = "LoginTest";
		try {
			//getting data
			userName = loginTestData.getCellData(sheetName, "UserName", 1);
			passWord = loginTestData.getCellData(sheetName, "PassWord", 1);
			loginPage.clickToUsernameField(userName);
			loginLog.log(Status.INFO, "Successfully click to username field");
			String value =  loginPage.getUsername();
			loginLog.log(Status.INFO, "Successfully get username from username field");
			System.out.println(value);
			loginPage.clickToPasswordField(passWord);
			loginLog.log(Status.INFO, "Successfully click to password field");
			String value1 =  loginPage.getPassword();
			loginLog.log(Status.INFO, "Successfully get password from password field");
			System.out.println(value1);
			loginPage.clickToSignInButton();
			loginLog.log(Status.INFO, "Successfully click to login button");
			loginLog.log(Status.INFO, "Employee successfully navigte to Employee home page");
		}catch(Exception loginTestException) {
			loginLog.log(Status.ERROR, MarkupHelper.createLabel("Exception in login test", ExtentColor.ORANGE));
			DriverUtilities.logScreenshot(androidDriver, loginLog, "Login_Exception"); 
		}
		if(moduleScriptName.isEmpty()) {
			androidDriver.quit();
			loginLog.log(Status.INFO, "Appliction Closed");
			DriverUtilities.stopServer();
			loginLog.log(Status.INFO, "Sever successfully stopped");
		}
		extent.flush();
	}
}
