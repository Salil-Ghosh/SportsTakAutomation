package com.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"json:target/cucumber-test-reports/RerunFailedCucumber.json" }, features = "@reports/rerun.txt", glue = "com.stepdefinitions")

public class FailedRunner extends AbstractTestNGCucumberTests {

}