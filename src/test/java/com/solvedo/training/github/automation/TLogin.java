package com.solvedo.training.github.automation;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TLogin {
	
	private WebDriver driver;

	@Before
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testLogin(){
		//navigate to main page
		driver.get("https://github.com");
		driver.findElement(By.linkText("Sign in")).click();
	    driver.findElement(By.id("login_field")).clear();
	    driver.findElement(By.id("login_field")).sendKeys("user1");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("123456");
	    driver.findElement(By.name("commit")).click();
	    
	    assertEquals("Incorrect username or password.", 
	    		driver.findElement(By.xpath("//div[@id='js-flash-container']/div/div")).getText());
	}	
}
