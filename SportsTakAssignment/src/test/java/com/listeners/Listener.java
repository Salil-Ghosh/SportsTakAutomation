package com.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
	Logger log =LogManager.getLogger(ITestListener.class);
	public void onTestStart(ITestResult result) {
		log.info("***************** Test Started  " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		
		log.info("***************** Test Passed  " + result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		log.info("***************** Test Failed  " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		log.info("***************** Test Skiped  " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		log.info("Execution started on Local env...  ");
		
	}

	public void onFinish(ITestContext context) {
			
		log.info("Generated Report. . .");	
		
	}
}
