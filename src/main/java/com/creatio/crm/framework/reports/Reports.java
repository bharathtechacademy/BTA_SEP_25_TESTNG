package com.creatio.crm.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {

	/**
	 * This class will contain all the common methods to generate HTML reports to
	 * publish test results.
	 * 
	 * ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
	 * ExtentXReporter extentx = new ExtentXReporter("localhost");
	 * 
	 * ExtentReports extent = new ExtentReports(); extent.attachReporter(html,
	 * extentx);
	 * 
	 * extent.createTest("TestName").pass("Test Passed");
	 * 
	 * extent.flush();
	 */

	public static ExtentHtmlReporter html; // to create empty HTML report --> white paper
	public static ExtentReports extent; // to generate the report --> printer
	public static ExtentTest logger; // to log the test steps --> ink
	
	//Common method to set up the report.
	public static void setupReport() {
		html = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\AutomationReport.html");
		extent = new ExtentReports();
		extent.attachReporter(html);
	}
	
	//Common method to start the printing process for a particular test case within the report.
	public static void startReporting(String testCaseName) {
		logger = extent.createTest(testCaseName);
		logger.info("Test Case Execution Started: " + testCaseName);
	}
	
	//Common method to end the report generation process.
	public static void endReporting() {
		extent.flush();
	}

}
