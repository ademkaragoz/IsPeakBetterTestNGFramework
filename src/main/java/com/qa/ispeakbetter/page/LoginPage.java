package com.qa.ispeakbetter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispearbetter.base.BasePage;
import com.qa.ispearbetter.util.ElementUtil;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//Locator
    By loginBtn = By.id("cmdSiginLink");
    By email = By.id("_email");
	By password = By.id("_password");
	By loginBtn2 = By.id("cmdSignin");
	By verifyMessage= By.id("crendentialsError");
	
	
	//Constructor
	public LoginPage (WebDriver driver) {
			this.driver = driver;
			elementUtil = new ElementUtil(driver);
	}

	//Actions
	public void doLoginPage() throws InterruptedException {
		Thread.sleep(6000);
		elementUtil.doClick(loginBtn);
		elementUtil.doSendKeys(email, "semih@gmail.com");
		elementUtil.doSendKeys(password, "test1234!");
		elementUtil.doClick(loginBtn2);
		elementUtil.waitForElementPresent(verifyMessage);
		//elementUtil.doGetText(verifyMessage);
	}
	
	public String getErrorMessage() throws InterruptedException {
		Thread.sleep(3000);
		//elementUtil.waitForElementPresent(verifyMessage);
		return elementUtil.doGetText(verifyMessage);
	}

}
