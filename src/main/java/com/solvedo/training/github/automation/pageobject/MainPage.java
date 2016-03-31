package com.solvedo.training.github.automation.pageobject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class MainPage extends LoadableComponent<MainPage>{
	private WebDriver driver;

	@FindBy(linkText ="Sign in")
	private WebElement signInLink;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		
		
	}
	
	public LoginPage navigateToLoginPage(){
		this.signInLink.click();
		return new LoginPage(driver).get();
	}

	@Override
	protected void load() {
		driver.get("https://github.com");
//		System.out.println("Thread sleep ");
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//System.out.println("SOURCE:" + driver.getPageSource());
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertTrue(signInLink != null);
	}
}
