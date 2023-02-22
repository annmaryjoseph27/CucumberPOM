package com.cucumberpom.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberpom.base.BasePage;

public class CRMHomePage extends BasePage{

	public CRMHomePage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]") 
	public WebElement contactElement;
	
	@FindBy(xpath="//button[@class='ui linkedin button' and contains(text(),'Create')]")
	public WebElement newContact;
	
	@FindBy(xpath ="//a[contains(text(),'Free')]")
	public WebElement elementdisplay;
	
	public void homePageValidation() {
		
		Assert.assertEquals(true, elementdisplay.isDisplayed());
	}
	
	public ContactsEntryPage gotoContacts() {
		act = new Actions(driver);
		act.moveToElement(contactElement).click().build().perform();
		newContact.click();
		return new ContactsEntryPage();
	}
	
	
}
