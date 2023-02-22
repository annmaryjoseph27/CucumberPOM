package com.cucumberpom.stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.cucumberpom.base.BasePage;
import com.cucumberpom.pages.CRMHomePage;
import com.cucumberpom.pages.ContactsEntryPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CRMHomePageStepDefinitions {
	
	CRMHomePage crmHomePage;
	ContactsEntryPage contactsEntryPage;
	
	@When("User navigate to user profile page")
	public void user_navigate_to_user_profile_page() {
	    // Write code here that turns the phrase above into concrete actions
		crmHomePage = new CRMHomePage();
		crmHomePage.homePageValidation();
	
	}
	@Then("Mouse Hover on Contacts and Click new Contact")
	public void mouse_hover_on_contacts() {
	    // Write code here that turns the phrase above into concrete actions
		contactsEntryPage = crmHomePage.gotoContacts();
		
	}

}
