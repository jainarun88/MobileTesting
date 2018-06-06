package com.mobileNew;

import java.util.Date;

public class JavaUtilities {
	
	public static void scriptWait(int time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
	
	/**
	 * This method Generate file name with date/timestamp as postfix to it
	 * 
	 * @param baseFileName
	 * @return
	 */
	public static String generateResultFileName(final String baseFileName, final String extension) {
		return (baseFileName + "_" + AppConstants.REPORT_DATE_FORMAT.format(new Date()) + extension);
	}
}
