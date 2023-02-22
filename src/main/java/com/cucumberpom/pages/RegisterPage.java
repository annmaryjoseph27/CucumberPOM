package com.cucumberpom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberpom.base.BasePage;



public class RegisterPage extends BasePage{

	public RegisterPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Got an account')]")	
	public WebElement gotAccountBtn;
	
	public PortfolioLoginPage clickGotAccountLink() {
		gotAccountBtn.click();
		return new PortfolioLoginPage();
		
	}
	
}
