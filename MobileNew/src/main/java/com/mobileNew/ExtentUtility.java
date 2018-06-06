package com.mobileNew;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentUtility {
	/**
	 * method to set configuration for extent reports
	 * 
	 * @param htmlReporter
	 * @param extent
	 * @param hostname
	 * @param environment
	 * @param username
	 * @param docTitle
	 * @param reportName
	 * @return extent
	 */
	public static ExtentReports getExtentReportConfig(final ExtentHtmlReporter htmlReporter, ExtentReports extent,final String hostname, final String environment, final String username, final String docTitle, final String reportName)
	{
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		//extent.setSystemInfo("Host Name", hostname);
		extent.setSystemInfo("Environment",environment );
		//extent.setSystemInfo("User Name", username);
		htmlReporter.config().setDocumentTitle(docTitle);
		htmlReporter.config().setReportName(reportName);
		htmlReporter.config().setChartVisibilityOnOpen(false);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		return extent;
	}
	
	/**
	 * This method is used for extent test when url open failure occurs
	 * 
	 * @param testName
	 * @param testReportPath
	 */
	public static void severFailureReport(final String testName, final String description, final String testReportPath)
	{
		ExtentReports extent = null;
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(testReportPath);
		extent = ExtentUtility.getExtentReportConfig(htmlReporter, extent, "Teemwurk", "QA", "Arun Jain", "Teemwurk", "Teemwurk Mobile Automation");
		ExtentTest test = extent.createTest(testName, description);
		test.log(Status.INFO, "This test is created when server is not started");
		test.log(Status.ERROR, "Server is not started");
		extent.flush();
	}

}
