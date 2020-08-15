package com.qa.ispearbetter.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.page.LoginPage;
import com.qa.ispearbetter.base.BasePage;
import com.qa.ispearbetter.util.Constants;

public class LoginPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
	}
	
	@Test(priority=1, description="Enter Invalid Credentials...!")
	public void doLoginPageTest() throws InterruptedException {
		loginPage.doLoginPage();
		
	}
	
	@Test(priority=2 , description= "Get error message as Wrong Username or password!")
	public void verifyErrorMessage() throws InterruptedException {
		String text = loginPage.getErrorMessage();
		System.out.println("Get error message :: " + text);
		Assert.assertEquals(text, Constants.ERROR_MESSAGE);
	}
	
	@AfterTest
	public void tearDown2() {
		driver.quit();
	}

}
