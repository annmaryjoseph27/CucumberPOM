package com.cucumberpom.stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.cucumberpom.base.BasePage;
import com.cucumberpom.pages.CRMHomePage;
import com.cucumberpom.pages.PortfolioLoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PortFolioLoginPageStepDefinitions {

	PortfolioLoginPage portfolioLoginPage;
	CRMHomePage crmHomePage;
	
	@When("user is on the Login page")
	public void user_is_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("Cogmento CRM", BasePage.getTitle());
	}
	@Then("User enters username and password")
	public void user_enters_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		portfolioLoginPage = new PortfolioLoginPage();
		crmHomePage = portfolioLoginPage.doLogin();
		
	
	}
	
}
