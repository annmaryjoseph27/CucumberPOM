package com.cucumberpom.pages;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberpom.base.BasePage;

public class ContactsEntryPage extends BasePage{
	
	@FindBy(xpath="//input[@name='first_name']") 
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='position']")
	WebElement position;
	
	@FindBy(xpath="//input[@name='department']")
	WebElement department;
	
	@FindBy(xpath="//button[@class='ui linkedin button' and contains(text(),'Save')]")
	WebElement saveButton;
	
	public ContactsEntryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterContactDetails(String firstname,String lastname,String positioN, String departmenT) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().refresh(); 
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		try {
			BasePage.takeScreenshot();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		position.sendKeys(positioN);
		department.sendKeys(departmenT);
	}
	
	public ContactEntryInfoPage saveContact() {
		saveButton.click();
		return new ContactEntryInfoPage();
	}

}
