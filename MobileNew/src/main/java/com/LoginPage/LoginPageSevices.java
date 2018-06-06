package com.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mobileNew.JavaUtilities;

import io.appium.java_client.android.AndroidDriver;


public class LoginPageSevices /*extends Driver*/{

	LoginPageObjects loginPage;
	String userName = "";
	String passWord = "";

	public LoginPageSevices(AndroidDriver<WebElement> driver) {
		super();
		loginPage = new LoginPageObjects();
		PageFactory.initElements(driver, loginPage);
	}

	public boolean validateLoginpage(){
		boolean elements = false;
		if(loginPage.userNameFld.isDisplayed()){
			if(loginPage.passwordField.isDisplayed()){
				if(loginPage.loginBtn.isDisplayed()){
					elements = true;
				}
			}
		}
		else{
			elements = false;
		}
		return elements;


	}

	public boolean testLoginWithoutCredentials() {
		boolean loginStatus = false;
		loginPage.loginBtn.click();
		if (loginPage.inputError.getText().equalsIgnoreCase("Username is mandatory")) {
			loginStatus = true;
		}
		loginPage.userNameFld.sendKeys(userName);
		loginPage.loginBtn.click();
		if (loginPage.inputError.getText().equalsIgnoreCase("Password is mandatory")) {
			loginStatus = true;
		}
		return loginStatus;

	}

	public void clickToUsernameField(String value) throws InterruptedException {
		JavaUtilities.scriptWait(1000);
		loginPage.userNameFld.click();
		System.out.println("User Name field clicked Successfully...");
		JavaUtilities.scriptWait(1000);
		loginPage.userNameFld.sendKeys(value);
		System.out.println("Successfully Pass the value :: "+value);
	}
	
	public String getUsername() throws InterruptedException {
		JavaUtilities.scriptWait(1000);
		return loginPage.userNameFld.getText();
	}
	
	public void clickToPasswordField(String value) throws InterruptedException {
		JavaUtilities.scriptWait(1000);
		loginPage.passwordField.click();
		System.out.println("Password field clicked Successfully...");
		JavaUtilities.scriptWait(1000);
		loginPage.passwordField.sendKeys(value);
		System.out.println("Successfully Pass the value :: "+value);
	}
	
	public String getPassword() throws InterruptedException {
		JavaUtilities.scriptWait(1000);
		return loginPage.passwordField.getText();
	}
	
	public void clickToSignInButton() throws InterruptedException {
		JavaUtilities.scriptWait(1000);
		loginPage.loginBtn.click();
		JavaUtilities.scriptWait(2000);
	}
}