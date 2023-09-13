package org.PomPage;

import org.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword extends BaseClass{
	public  ForgotPassword() {
		
		 PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath="//a[text()='Forgotten password?']")
	 private WebElement forgotPassword;
	 @FindBy(xpath="//input[@aria-label='Email address or mobile number']")
	 private WebElement enterValue;
	 @FindBy (xpath="//button[@value='1']")
	 private WebElement searchButton;
	 
	 public WebElement getforgotPassword() {
			return forgotPassword;
	 }
	 public WebElement getenterValue() {
			return enterValue;
			
	}
	 public WebElement getsearchButton() {
			return searchButton;
	}

}
