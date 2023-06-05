package com.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestContext {
	private WebDriver driver;
	Logger log =LogManager.getLogger(TestContext.class);

	private ScenarioContext scenarioContext;


	public TestContext() {
		ConfigFileReader cr= new ConfigFileReader();
		String browserName=cr.getBrowserName();
		
		String disableNotification=cr.getDisableNotification();
		ChromeOptions options = new ChromeOptions();
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (disableNotification.equalsIgnoreCase("true")) {
				options.addArguments("--disable-notifications");
				log.debug("-------------Disabling The Notification---------------");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}
		}else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			driver = null;
		}
		scenarioContext = new ScenarioContext();

	}


	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}

