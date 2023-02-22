package com.cucumberpom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberpom.base.BasePage;



public class LandingPage extends BasePage {

	public LandingPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Sign')]")	
	public WebElement signUpBtn;
	
	
	
	public RegisterPage clickSignUPLink() {
		
		//logger.log(Status.INFO, "Clicking on SignUp Button");
		signUpBtn.click();
		//logger.log(Status.PASS, "Clicked on SignUp Button");
		//RegisterPage registerPage = new RegisterPage(driver,logger);
		//PageFactory.initElements(driver, registerPage);
		return new RegisterPage();
	}
	
}
