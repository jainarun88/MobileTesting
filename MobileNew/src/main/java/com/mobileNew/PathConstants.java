package com.mobileNew;

import java.util.Date;

public interface PathConstants {
	public String TESTSCRIPTRESULTSPATH = AppConstants.CLASSPATH + AppConstants.FILE_SEPARATOR+"results"+AppConstants.FILE_SEPARATOR+"TestScriptResults";
	public String TESTDATAPATH = AppConstants.CLASSPATH + AppConstants.FILE_SEPARATOR+"testData";
	public String SCREENSHOT_BASE_PATH = AppConstants.CLASSPATH + AppConstants.FILE_SEPARATOR+"results"+AppConstants.FILE_SEPARATOR+"Screenshots"+AppConstants.FILE_SEPARATOR;
	public String SCREENSHOT_FOLDER_PATH = SCREENSHOT_BASE_PATH + AppConstants.FILE_SEPARATOR + "Screenshot_"+AppConstants.REPORT_DATE_FORMAT.format(new Date());
}
