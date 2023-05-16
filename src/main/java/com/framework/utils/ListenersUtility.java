package com.framework.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.team.baseclass.BaseClass;


public class ListenersUtility implements ITestListener {
	ExtentSparkReporter sparkreporter;
	ExtentReports reports;
	ExtentTest test;
	WebDriverUtility wdu = new WebDriverUtility();
	JavaUtility jutility = new JavaUtility();
	LogUtility logutility = new LogUtility();

	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test = reports.createTest(methodname);
		logutility.info(methodname +"-> Test case started");
	}

	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.PASS, MarkupHelper.createLabel(methodname, ExtentColor.GREEN));
		test.log(Status.INFO, methodname+ "---> Passed");
		logutility.pass(methodname +"-> Test case executed sucessfully");
		}
	

	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.FAIL, MarkupHelper.createLabel(methodname, ExtentColor.RED));
		logutility.fail(methodname +"-> Test case failed");
		
		
		String screenShotName = methodname+"-"+jutility.getSystemdate();
		test.log(Status.INFO, methodname+ "---> Failed");
		test.log(Status.FAIL, result.getThrowable());
		try {
			String path = wdu.takeScreenShot(BaseClass.driver, screenShotName);
			
			test.addScreenCaptureFromPath(path); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, MarkupHelper.createLabel(methodname, ExtentColor.ORANGE));
		logutility.info(methodname +"-> Test case skipped");

	}

	public void onStart(ITestContext context) {
		
		String repname = "Test-Report-" +new JavaUtility().getSystemdate() + ".html";
		logutility.info(repname +"-> Report generating started");

		sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentsReports/" + repname);
		sparkreporter.config().setDocumentTitle("OrangeHRM reports");
		sparkreporter.config().setReportName("Test Case ");
		sparkreporter.config().setTheme(Theme.STANDARD);

		reports = new ExtentReports();
		reports.attachReporter(sparkreporter);
		reports.setSystemInfo("URl", "https://www.Orangehrm.com");
		reports.setSystemInfo("OPERATING SYSTEM", "Window");
		reports.setSystemInfo("BROWSER", "Chrome");
		
	        

	}

	public void onFinish(ITestContext context) {
		reports.flush();
		logutility.info("-> Report generated sucessfully");
		logutility.info("----------------------------------------------------------------------------");
		
	    
	   

	}

}



