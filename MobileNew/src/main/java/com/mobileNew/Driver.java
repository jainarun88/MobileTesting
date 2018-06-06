package com.mobileNew;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class Driver extends BaseSetup{

    protected AndroidDriver<WebElement> driver;

    public Driver() {
        this.driver = super.getDriver();
    }
}