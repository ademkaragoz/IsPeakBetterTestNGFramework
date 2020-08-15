package com.qa.ispearbetter.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.page.HomePage;
import com.qa.ispearbetter.base.BasePage;
import com.qa.ispearbetter.util.Constants;

public class HomePageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
	}
	
   @Test(priority=1, description="Home page header message as Speak English Better Wherever You Are")
	public void verifyHomePageHeaderMessage() throws InterruptedException {
		String text1 = homePage.getHomePageHeaderMessage();
		System.out.println("Home page header message ::" + text1);
		Assert.assertEquals(text1, Constants.HEADER_MESSAGE);
	}
	
	@Test(priority=2, description="Home page title as Learn English with Online Teachers - Get your Free Live English Class Now.")
	public void verifyLoginPageTitle() {
		String text2 = homePage.getHomePageTitle();
		System.out.println("Page Title is :" + text2);
		Assert.assertEquals(text2, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=3, description= "Click on chat box button")
	public void doChatButton() throws InterruptedException {
		homePage.clickOnChatButton();
	}
	
	@Test(priority=4, description= "Chat box header message as Chat with us now!", enabled=false)
	public void verifyChatBoxHeader() throws InterruptedException {
		String text3 = homePage.getChatBoxMessage();
		System.err.println("Chat box header :" + text3);
		Assert.assertEquals(text3, Constants.CHAT_BOX_HEADER);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	

}
