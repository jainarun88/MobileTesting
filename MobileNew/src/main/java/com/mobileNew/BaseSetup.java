package com.mobileNew;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;

public class BaseSetup {

       public static AndroidDriver<WebElement> androidDriver = null;
      
        @BeforeSuite
        public void serverStart() {
    		DriverUtilities.startServer();
    	}

        @BeforeClass
        public void setup(){
        	androidDriver = DriverUtilities.initDriver(androidDriver);
        	//initDriver();
        }

        public AndroidDriver<WebElement> getDriver() {
            return androidDriver;
        }

        @AfterClass
        public void tearDown(){
            androidDriver.quit();
        }
        
        @AfterSuite
        public void serverStop() {
    		DriverUtilities.stopServer();
    	}
    }
