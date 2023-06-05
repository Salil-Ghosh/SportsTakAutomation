package com.sportstakpages;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.CommonMethods;

public class WebStoriesPage {

	WebDriver driver;
	Logger log =LogManager.getLogger(WebStoriesPage.class);
	public WebStoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@aria-label='Next Story']")
	WebElement NextWebStoryPageButton;

	public void captureTextOnWebStoriesOnPage(String pageNo) throws InterruptedException {
		
		log.debug("Entering into Method: captureTextOnWebStoriesOnPage");
		
		int PageNo = Integer.parseInt(pageNo);
		scrollToPage(PageNo);
		List<WebElement> webStories = driver.findElements(By.xpath("//section[@class='webstories-title']//p"));
		for (int i = 0; i < webStories.size(); i++) {
			int WebStoryNumber = i+1;
			log.debug("Web story " + WebStoryNumber + " text is: " + webStories.get(i).getText());
		}
		
		log.debug("Exiting from Method: captureTextOnWebStoriesOnPage");
	}

	public void scrollToPage(int pageNo) throws InterruptedException {
		
		log.debug("Entering into Method: scrollToPage");
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		for (int i = 1; i < pageNo; i++) {
			je.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
		}
		
		log.debug("Exiting from Method: scrollToPage");
	}

	public void clickOnWebStory(String webStoryNo) throws InterruptedException {
		
		log.debug("Entering into Method: scrollToPage");
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement WebStoryWebElement = driver
				.findElement(By.xpath("(//section[@class='webstories-title']//p)" + "[" + webStoryNo + "]"));
		je.executeScript("arguments[0].click();", WebStoryWebElement);
		
		log.debug("Exiting from Method: scrollToPage");
		
	}
	
	public void clickOnNextWebStoryButton() {
		
		log.debug("Entering into Method: clickOnNextWebStoryButton");
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		WebElement nextStoryButton = (WebElement) js.executeScript("return document.querySelector('amp-story-player').querySelector('div').shadowRoot.querySelectorAll('button')[1]");
		// now you can click on clear data button
		nextStoryButton.click();
		driver.navigate().back();
		
		log.debug("Exiting from Method: clickOnNextWebStoryButton");
	}
	
	 

}