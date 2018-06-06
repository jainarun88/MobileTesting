package com.mobileNew;

import java.text.SimpleDateFormat;

public interface AppConstants {
	
	public static String CLASSPATH = System.getProperty("user.dir");
	public static String SERVER_IP = "127.0.0.1";
	public static String PORT_ID = "4723";
	public static String FILE_SEPARATOR = "\\";
	public static String SEVER_URL = "http://" + AppConstants.SERVER_IP + ":" + AppConstants.PORT_ID + "/wd/hub";
	public static String APP = "D:\\MobileTesting\\platform-tools\\TeemWurkApp_v1.2_25_01_2018.apk";
	public static SimpleDateFormat REPORT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	public static String HTML_EXTENSION = ".html";
	public static String PNG_EXTENSION = ".png";
	public static String HOSTNAME = "Teemwurk";
	public static String ENVIRONMENT = "QA";
	public static String USERNAME_REPORT = "Arun Kumar Jain";
	public static String DOC_TITLE = "Mobile Automation Test Results";
	//Capabilities part
	public static String PLATFORM_NAME = "Android";
	public static String DEVICE_NAME = "Android device";
	public static String UDID = "emulator-5554";
	public static String PLATFORM_VERSION = "8.1";
	public static String APP_PACKAGE = "com.teemwurk";
	public static String APP_ACTIVITY = "com.teemwurk.LoginActivity";
	public static String NEW_COMMAND_TIMEOUT = "3000";
	public static boolean NO_RESET = true;
	
	
	
	
	
}
