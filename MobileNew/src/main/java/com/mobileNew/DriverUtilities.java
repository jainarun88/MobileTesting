package com.mobileNew;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverUtilities {

	public static boolean startServer() {
		boolean isSeverStart = false;
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
			JavaUtilities.scriptWait(20000);
			System.out.println("Server started...");
			isSeverStart = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSeverStart;
	}

	public static void stopServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
			runtime.exec("taskkill /F /IM cmd.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static DesiredCapabilities setCapabilities(){
		DesiredCapabilities cap = new DesiredCapabilities();
		System.out.println("Inside initDriver method");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, AppConstants.PLATFORM_NAME);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, AppConstants.DEVICE_NAME);
		cap.setCapability(MobileCapabilityType.UDID, AppConstants.UDID);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, AppConstants.PLATFORM_VERSION);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, AppConstants.APP_PACKAGE);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, AppConstants.APP_ACTIVITY);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, AppConstants.NEW_COMMAND_TIMEOUT);
		// cap.setCapability(MobileCapabilityType.APP, AppConstant.APP);
		cap.setCapability(MobileCapabilityType.NO_RESET, AppConstants.NO_RESET);
		
		return cap;
	}

	public static AndroidDriver<WebElement> initDriver(AndroidDriver<WebElement> androidDriver){
		DesiredCapabilities cap = setCapabilities();
		try
		{
			System.out.println("Argument to driver object : " + AppConstants.SEVER_URL);
			androidDriver = new AndroidDriver<WebElement>(new URL(AppConstants.SEVER_URL), cap);
		}
		catch (Exception ex) {
			throw new RuntimeException("appium driver could not be initialised for device ");
		}
		System.out.println("Driver in initdriver is : "+androidDriver);
		
		return androidDriver;

	}
	
	/**
	 * method to use to attached screenshots to extent reports
	 * 
	 * @param driver
	 * @param log
	 * @param imageName
	 */
	public static void logScreenshot(AndroidDriver<WebElement> androidDriver, ExtentTest log, String imageName){
		String path = PathConstants.SCREENSHOT_FOLDER_PATH + AppConstants.FILE_SEPARATOR + JavaUtilities.generateResultFileName(imageName, AppConstants.PNG_EXTENSION);
		try {
			takeScreenShot(androidDriver, path);
			log.log(Status.INFO, "Failure screenshot :: "+log.addScreenCaptureFromPath(path)); 
		}catch(Exception e) {
			e.getMessage();
		}
	}

	/**
	 * method to use to take screenshots
	 * 
	 * @param driver
	 * @param path
	 */
	public static void takeScreenShot(AndroidDriver<WebElement> androidDriver, String path){
		try{
			File scrFile = ((TakesScreenshot)androidDriver).getScreenshotAs(OutputType.FILE);  
			FileUtils.copyFile(scrFile, new File(path));
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * method to use to save screenshots to specific folder
	 * 
	 * @param imageUrl
	 * @param destinationFile
	 * @throws IOException
	 */
	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);
		byte[] b = new byte[2048];
		int length;
		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}
		is.close();
		os.close();
	}
}
