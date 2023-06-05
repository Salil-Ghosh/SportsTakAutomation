package com.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "json:target/cucumber-test-reports/Cucumber.json",
        "rerun:reports/rerun.txt" }, features = "src/test/resources/FeatureFiles", glue = "com.stepdefinitions")

public class TestRunner extends AbstractTestNGCucumberTests {

    
}
