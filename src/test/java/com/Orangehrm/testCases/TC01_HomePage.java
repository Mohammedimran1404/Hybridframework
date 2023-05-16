package com.Orangehrm.testCases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.Orangehrm.pageObjects.HomePage;
import com.Orangehrm.pageObjects.LoginPage;
import com.team.baseclass.BaseClass;

public class TC01_HomePage extends BaseClass {
 
	@Test
	//(dataProvider="jsonhomepage",dataProviderClass = JsonUtility.class)
	public void homePageTest() throws IOException, ParseException {
		String admin = jutility.jsonDataReader("usernameAdmin");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		HomePage hp = new HomePage(driver);
		hp.clickTime();
		hp.enterEmployeeName(admin);
		hp.clickBtnView();
	
	}

}
