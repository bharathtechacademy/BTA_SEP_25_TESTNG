package com.creatio.crm.framework.listeners;

import org.testng.ITestResult;

public class TestListeners {
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test Execution started: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Executed successfully: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Execution failed: " + result.getName());
		System.out.println("Failure Reason: " + result.getThrowable().getLocalizedMessage());
		System.out.println("Taking screenshot for failed test case: " + result.getName());
	}

}
