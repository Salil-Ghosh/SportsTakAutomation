package com.stepdefinitions;

import com.utilities.CommonMethods;
import com.utilities.ConfigFileReader;
import com.utilities.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import java.util.concurrent.TimeUnit;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.sportstakpages.CricketPage;
import com.sportstakpages.HomePage;
import com.sportstakpages.WebStoriesPage;



public class SportsTakStepDefinitions  {
	TestContext ctxt = new TestContext();
	ConfigFileReader obj= new ConfigFileReader(); 
	private WebDriver driver=ctxt.getDriver();
	Logger log = LogManager.getLogger(SportsTakStepDefinitions.class);
	@Before(order = 0)
	public void setScenarioValues(Scenario scenario) {


		ctxt.getScenarioContext().setContext("ScenarioName", scenario.getName());

		ctxt.getScenarioContext().setContext("ScenarioId", scenario.getId());

		ctxt.getScenarioContext().setContext("Scenario", scenario);
		
	}
	
	
	

	
	
	@Given("^Open the browser and enter SportsTak URL$")
	public void open_chrome_browser_and_enter_URL() throws Throwable {
		

		try {
			driver.get(obj.getApplicationUrl());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			CommonMethods.addStepLog(ctxt,"Opened chrome browser and entered url");
			CommonMethods.takeScreenShot(ctxt);			
			
		} catch (AssertionError | Exception e) {
			CommonMethods.takeScreenShot(ctxt);	
			CommonMethods.addStepLog(ctxt,"Unable To Open The Window");			
		}	
		
	}
	
	
	@Then("Click on each thumbnail and verify that links are not broken on Home")
	public void click_on_each_thumbnail_and_verify_that_links_are_not_broken_on_Home() throws Throwable {
			new HomePage(driver).getLinksAndVerify();
			
			CommonMethods.addStepLog(ctxt,"Clicked on each thumbnail and verifyed that links are not broken on Home");
			CommonMethods.takeScreenShot(ctxt);	
	}

	@And("Click on \"([^\"]*)\"$")
	public void click_on(String tabName) throws Throwable {
			switch(tabName) {
			case "Cricket":
				new HomePage(driver).clickOnTab(tabName);
				break;
			case "Web Stories":
				new HomePage(driver).clickOnTab(tabName);
				break;
			default:
				CommonMethods.addStepLog(ctxt,"No such tab exists.");
			}
			CommonMethods.addStepLog(ctxt,"Clicked on the channel name");
			CommonMethods.takeScreenShot(ctxt);	
			
		
	}

	@Then("scroll to the page {string} and click on the links and verify the links are not broken.")
	public void scroll_to_the_page_and_click_on_the_links_and_verify_the_links_are_not_broken(String pageNo) throws Throwable {

			new CricketPage(driver).scrollToPage(Integer.parseInt(pageNo));
			new CricketPage(driver).getLinksAndVerifyOnPage(Integer.parseInt(pageNo));
			
			CommonMethods.addStepLog(ctxt,"clicked on the links and verifyed the links are not broken.");
			CommonMethods.takeScreenShot(ctxt);	
			
		
	}

	@And("Change the theme from {string} to {string}.")
	public void change_the_theme_from_to_or_vice_versa(String col1, String col2) throws Throwable {
	    


			new CricketPage(driver).changeBackGroundColTo(col2);
			
			CommonMethods.addStepLog(ctxt,"Changed the theme from" + col1 + "to "+col2+" or vice versa.");
			CommonMethods.takeScreenShot(ctxt);	
			
	
		
		
	}

	@And("Capture the text on each Web Stories on page {string}.")
	public void capture_the_text_on_each_Web_Stories_on_page(String pageNo) throws Throwable {
		
			new WebStoriesPage(driver).captureTextOnWebStoriesOnPage(pageNo);
			
			CommonMethods.addStepLog(ctxt,"Captured the text on each Web Stories on page "+pageNo);
			CommonMethods.takeScreenShot(ctxt);	
	    
	}

	@And("Click on {string} webstory displayed.")
	public void click_on_webstory_displayed(String webStoryNo) throws Throwable {
	
			new WebStoriesPage(driver).clickOnWebStory(webStoryNo);
			
			CommonMethods.addStepLog(ctxt,"Clicked on "+webStoryNo+" webstory displayed.");
			CommonMethods.takeScreenShot(ctxt);	
		
	}

	@Then("click on the next webstory and return to the homepage.")
	public void click_on_the_next_webstory_and_return_to_the_homepage() throws Throwable {

		new WebStoriesPage(driver).clickOnNextWebStoryButton();

		CommonMethods.addStepLog(ctxt, "clicked on the next webstory and returned to the CricketPage.");
		CommonMethods.takeScreenShot(ctxt);

		CommonMethods.addStepLog(ctxt, "Closing the browser.");
		driver.quit();
		CommonMethods.addStepLog(ctxt, "Closed the browser.");
	}

}