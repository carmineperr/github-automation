package com.solvedo.training.github.automation.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

/**
 * This class models the login page of gitHub.
 * @author Carmine
 *
 */
public class LoginPage extends LoadableComponent<LoginPage>{
		
	private WebDriver driver;
	@FindBy(id="login_field")
	private WebElement usernameField;
	@FindBy(id="password")
	private WebElement passwordField;
	@FindBy(name="commit")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void login(){
		usernameField.clear();
		usernameField.sendKeys("user1");
		passwordField.clear();
		passwordField.sendKeys("123456");
		loginButton.click();
	}
	
	public String getLoginMessage(){
		return driver.
				findElement(
						By.xpath("//div[@id='js-flash-container']/div/div")).
				getText();		
	}

	@Override
	protected void load() {
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertTrue(usernameField != null);
		
	}
}
