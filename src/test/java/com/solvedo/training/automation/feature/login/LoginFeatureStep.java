package com.solvedo.training.automation.feature.login;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;
import com.solvedo.training.github.automation.pageobject.LoginPage;
import com.solvedo.training.github.automation.pageobject.MainPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginFeatureStep {
	
	private WebDriver driver;
	private MainPage mainPage;
	private LoginPage loginPage;
	
	@Before
	public void setup() throws Exception{
		//driver = new FirefoxDriver();
		driver = new JBrowserDriver(Settings.builder().
			      timezone(Timezone.EUROPE_ROME).build());
		JBrowserDriver driver = new JBrowserDriver();
		
		//driver = new RemoteWebDriver(new URL("http://127.0.0.1:7963"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
		
	@Given("^I am in the application main page$")
	public void i_am_in_the_application_main_page() throws Throwable {
		mainPage = new MainPage(driver).get();
	}

	@When("^I navigate to login page$")
	public void i_navigate_to_login_page() throws Throwable {
		loginPage = mainPage.navigateToLoginPage();
	}
	
	@When("I login in the application using wrong credentials")
	public void i_login_with_user_user_and_password() throws Throwable {
	    loginPage.login();
	}

	@Then("^I get an error message$")
	public void i_get_an_error_message() throws Throwable {
		assertEquals("Incorrect username or password.", loginPage.getLoginMessage());
	}
	
	@After
	public void shuttingDown(){
		driver.quit();
	}
}
