package com.cucumberpom.stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.cucumberpom.base.BasePage;
import com.cucumberpom.pages.ContactEntryInfoPage;
import com.cucumberpom.pages.ContactsEntryPage;

import io.cucumber.java.en.Then;

public class ContactsEntryPageStepDefinitions {
	ContactsEntryPage contactsEntryPage;
	ContactEntryInfoPage contactEntryInfoPage;

	@Then("^User enters Contact Details (.*) and (.*) and (.*) and (.*)$")
	public void user_enters_contact_details_deepu_and_jose_and_qa_tester_and_testing(String firstname, String lastname, String position, String department) {
	    // Write code here that turns the phrase above into concrete actions
		contactsEntryPage = new ContactsEntryPage();
		contactsEntryPage.enterContactDetails(firstname,lastname,position,department);

	}
	@Then("Click Submit button")
	public void click_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
		contactEntryInfoPage = contactsEntryPage.saveContact();
		try {
			BasePage.takeScreenshot();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
