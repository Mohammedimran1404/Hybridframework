package com.team.baseclass;





import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.framework.utils.JsonUtility;
import com.framework.utils.LogUtility;
import com.framework.utils.PropertyFileUtility;
import com.framework.utils.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	public PropertyFileUtility propertyFileUtility = new PropertyFileUtility();
	public WebDriverUtility wutility = new WebDriverUtility();
	public  JsonUtility jutility = new JsonUtility();
	public LogUtility logutility = new LogUtility();

	
	public String baseUrl = propertyFileUtility.getApplictionUrl();
	public String username = propertyFileUtility.getUserName();
	public String password = propertyFileUtility.getPassword();
	


	public static WebDriver driver;


	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logutility.info("Chrome browser started sucessfully");
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logutility.info("Edge browser started sucessfully");
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logutility.info("Fire fox browser started sucessfully");
		} else {
			System.out.println("invalid browser");
			logutility.fail("Invalid browser");
		}
		driver.get(baseUrl);
		logutility.info("Url is opened");
		//wutility.waitForElementsToLoadInDOM(driver);
		wutility.maximiseWindow(driver);

		System.out.println("OS name -> " + System.getProperty("os.name"));
		System.out.println("OS version -> " + System.getProperty("os.version"));
		System.out.println("name ->"+System.getProperty("user.name"));
		System.out.println("Java Version"+System.getProperty("java.version")); 

		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println("Browser name is -> "+browserName);
		String browserversion = cap.getBrowserVersion().toString();
		System.out.println("browser version is -> "+browserversion);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		logutility.info("Browser quit sucessfully");
		
	}

}
