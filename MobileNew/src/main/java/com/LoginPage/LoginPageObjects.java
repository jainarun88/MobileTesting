package com.LoginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.mobileNew.AppConstants;
import com.mobileNew.JavaUtilities;
import com.mobileNew.PathConstants;

public class LoginPageObjects {
	
	public static String HTMLREPORT_RESULT_PATH = PathConstants.TESTSCRIPTRESULTSPATH + AppConstants.FILE_SEPARATOR + "LoginPage" + AppConstants.FILE_SEPARATOR+ JavaUtilities.generateResultFileName("LoginPage", AppConstants.HTML_EXTENSION);
	public static String LOGIN_TESTDATA_PATH = PathConstants.TESTDATAPATH + AppConstants.FILE_SEPARATOR + "LoginPage" + AppConstants.FILE_SEPARATOR+ "TestDataLogin.xlsx";
	
	@CacheLookup
	@FindBy(id = "com.teemwurk:id/userNameET")
	public WebElement userNameFld;

	@CacheLookup
	@FindBy(id = "com.teemwurk:id/passwordET")
	public WebElement passwordField;

	@CacheLookup
	@FindBy(id = "com.teemwurk:id/signInBtn")
	public WebElement loginBtn;

	@CacheLookup
	@FindBy(name = "Invalid ID or password.")
	public WebElement inputError;
}
