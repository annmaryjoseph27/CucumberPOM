package com.cucumberpom.stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.cucumberpom.base.BasePage;
import com.cucumberpom.pages.LandingPage;
import com.cucumberpom.pages.RegisterPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LandingPageStepDefinitions extends BasePage{
	RegisterPage registerPage;
	LandingPage landingPage;
	
	@Before
	public void openBrowser() throws IOException {
		BasePage.initBrowser();
		BasePage.initFile();
		}
	@After
	public void tearDown() throws IOException {
		BasePage.closeFile();
		driver.quit();
	}
	@BeforeStep
	public void screenshotCapture() throws InvalidFormatException, IOException {
		BasePage.takeScreenshot();
		
		
	}
	
	@Given("User is on the Application Home Page")
	public void user_is_on_the_application_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.get(prop.getProperty("applicationURL"));
		landingPage = new LandingPage();
	
	}
	@When("Application Page Title is Free CRM")
	public void application_page_title_is_free_crm() {
	    // Write code here that turns the phrase above into concrete actions
		String expectedTitle = "#1 Free CRM Software for every business";
		Assert.assertEquals(expectedTitle, BasePage.getTitle());
	    
	}
	@Then("User click on SignUp button")
	public void user_click_on_sign_up_button() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		registerPage = landingPage.clickSignUPLink();
	
		
	}
}
