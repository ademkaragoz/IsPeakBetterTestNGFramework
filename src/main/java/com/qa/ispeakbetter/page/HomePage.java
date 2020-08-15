package com.qa.ispeakbetter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispearbetter.base.BasePage;
import com.qa.ispearbetter.util.Constants;
import com.qa.ispearbetter.util.ElementUtil;

public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//Locators
	By pageHeader = By.xpath("//h1[text()= 'Speak English Better Wherever You Are']");
	By chatButton = By.id("zsiq_agtpic");
	By iframeBox = By.xpath("//iframe[@id='siqiframe']");
	By chatBoxHeader = By.xpath("//div[@id='attname']");

	
	//Constructor
	public HomePage (WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	//Actions
	public String getHomePageHeaderMessage() throws InterruptedException {
		Thread.sleep(3000);
		return elementUtil.doGetText(pageHeader);
	}

	public String getHomePageTitle() {
	  elementUtil.waitForTitlePresent(Constants.HOME_PAGE_TITLE);
	  return elementUtil.doGetPageTitle();
		
	}
	
	public void clickOnChatButton() throws InterruptedException {
		elementUtil.doClick(chatButton);
		Thread.sleep(5000);
	}
	
	public String getChatBoxMessage() throws InterruptedException {
		Thread.sleep(2000);
	  //elementUtil.waitForElementPresent(chatBoxHeader);
	  return elementUtil.doGetText(chatBoxHeader);
	}
	
	
}


