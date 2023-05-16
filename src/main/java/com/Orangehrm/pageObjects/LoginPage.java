package com.Orangehrm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.utils.WebDriverUtility;


public class LoginPage  {
 WebDriverUtility wutility = new WebDriverUtility();
	WebDriver driver;
	public  LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(xpath="//input[@name='username']")private WebElement username1;
	@FindBy(xpath="//input[@name='password']")private WebElement password1;
	@FindBy(xpath="//button[contains(@class,'oxd-button')]")private WebElement loginbtn1;
	
	public void setUsername(String uname) {
		wutility.waitForElementToLoad(driver, username1);
	    username1.sendKeys(uname);
	}
	public void setPassword(String pass) {
		 password1.sendKeys(pass);;
	}
	public void clickLogin() {
		loginbtn1.click();
		
	}
	 
}

// another method
//public WebElement setUsername() {
//    return username1;
//}
//public WebElement setPassword() {
//	return password1;
//}
//public void clickLogin(String uname, String pass) {
//	username1.sendKeys(uname);
//	password1.sendKeys(pass);
//	loginbtn1.click();
//	
//}
// 
