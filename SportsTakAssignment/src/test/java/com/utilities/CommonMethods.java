package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sportstakpages.HomePage;

import io.cucumber.java.Scenario;

public class CommonMethods {
	static Logger log =LogManager.getLogger(CommonMethods.class);
	public static void addStepLog(TestContext ctxt, String message) {

		Scenario scenario = (Scenario) ctxt.getScenarioContext().getContext("Scenario");
		scenario.log(message);

	}

	public static String captureScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
				+ getcurrentdateandtime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public static String getcurrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {
		}
		return str;
	}

	public static String takeScreenShot(TestContext ctxt) throws Throwable {

		WebDriver driver = ctxt.getDriver();
		String Base64 = null;

		Base64 = "data:image/gif;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		Scenario scenario = (Scenario) ctxt.getScenarioContext().getContext("Scenario");

		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "Click Below for Screenshot");
		return Base64;

	}
	
	public static boolean isElementVisible(WebElement elem, WebDriver driver) {
		boolean isElementLocated = false;
		try {
			Point p = elem.getLocation();
			if (p.getX() == 0 && p.getY() == 0) {
				isElementLocated = false;
			} else {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(" + p.getX() + "," + (p.getY()) + ");");
				isElementLocated = true;
			}
		} catch (ElementNotInteractableException e) {
			log.error("Something went wrong:" + e);
			isElementLocated = true;
		}
		return isElementLocated;
	}


}
