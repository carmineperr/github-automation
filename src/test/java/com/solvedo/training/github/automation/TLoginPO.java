package com.solvedo.training.github.automation;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.solvedo.training.github.automation.pageobject.LoginPage;
import com.solvedo.training.github.automation.pageobject.MainPage;

public class TLoginPO {
	private WebDriver driver;

	@Before
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testLogin(){
		MainPage mainPage = new MainPage(driver).get();
		LoginPage loginPage = mainPage.navigateToLoginPage();
		loginPage.login();
		assertEquals("Incorrect username or password.", loginPage.getLoginMessage());
	}
	
	
	
}
