package com.cucumberpom.stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.cucumberpom.base.BasePage;
import com.cucumberpom.pages.PortfolioLoginPage;
import com.cucumberpom.pages.RegisterPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterPageStepDefinitions extends BasePage{
	RegisterPage registerPage;
	PortfolioLoginPage portfolioLoginPage;
	
	@When("Application Page Title is Cogmento CRM")
	public void application_page_title_is_cogmento_crm() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("Cogmento CRM", BasePage.getTitle());
	}
	@Then("User click on Got an account button")
	public void user_click_on_got_an_account_button() {
	    // Write code here that turns the phrase above into concrete actions
		registerPage = new RegisterPage();
		portfolioLoginPage = registerPage.clickGotAccountLink();

	}
	
}
