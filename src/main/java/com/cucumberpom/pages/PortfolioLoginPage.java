package com.cucumberpom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberpom.base.BasePage;

public class PortfolioLoginPage extends BasePage {

	public PortfolioLoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='email']")	
	public WebElement userNameTextBox;
	
	@FindBy(xpath="//input[@name='password']")	
	public WebElement passwordTextBox;
	
	@FindBy(xpath="//div[contains(text(),'Log')]")	
	public WebElement loginTextBox;
	
	public CRMHomePage doLogin(){
		
		userNameTextBox.sendKeys(prop.getProperty("userName"));
		passwordTextBox.sendKeys(prop.getProperty("password"));
		loginTextBox.click();
		return new CRMHomePage();   
	
	}
	}
