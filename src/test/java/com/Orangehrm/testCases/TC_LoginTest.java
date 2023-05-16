package com.Orangehrm.testCases;

import org.testng.annotations.Test;

import com.Orangehrm.pageObjects.LoginPage;
import com.team.baseclass.BaseClass;


public class TC_LoginTest extends BaseClass{
	@Test
	public void loginTest() {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		
		
		
	}
	
	

}
