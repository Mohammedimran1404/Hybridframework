package com.Orangehrm.pageObjects;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.utils.WebDriverUtility;



public class HomePage{
	 WebDriverUtility wutility = new WebDriverUtility();
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Time']")private WebElement clicktime;
	@FindBy(xpath="//input[@placeholder='Type for hints...']")private WebElement employeename;
    @FindBy(xpath="//button[@Class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")private WebElement btnview;
    
    public void clickTime() {
		wutility.waitForElementToLoad(driver,clicktime );
    	 clicktime.click();
    }
    public void enterEmployeeName(String uname ) throws IOException, ParseException {
    	wutility.waitForElementToBeClickable(driver, employeename);
    	employeename.sendKeys(uname);
    }
    public void clickBtnView() {
    	btnview.click();
    }
  
}
