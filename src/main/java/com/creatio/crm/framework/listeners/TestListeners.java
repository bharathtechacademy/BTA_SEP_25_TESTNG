package com.creatio.crm.framework.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.web.commons.WebCommons;

public class TestListeners extends Reports implements ITestListener {
	
	String testName;
	
	public void onTestStart(ITestResult result) {
		testName = result.getMethod().getMethodName();
		startReporting(testName);
	}

	public void onTestSuccess(ITestResult result) {
		logger.pass("Test Executed successfully: " + testName);
		endReporting();
	}

	public void onTestFailure(ITestResult result) {
		logger.fail("Test Execution failed: " + testName);
		logger.fail("Failure Reason: " + result.getThrowable().getLocalizedMessage());
		try {
			logger.addScreenCaptureFromPath(WebCommons.getWindowScreenshot(BasePage.getDriver(), testName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		endReporting();	
	}

}
