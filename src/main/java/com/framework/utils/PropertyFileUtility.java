package com.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	Properties pro;

	public PropertyFileUtility() {

		File f = new File(ConstantUtility.propertyFilePath);
		try {
			FileInputStream fis = new FileInputStream(f);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	}
	public String getApplictionUrl() {
		String url = pro.getProperty("baseUrl");
		return url;
	}
	public String getUserName() {
		String usern = pro.getProperty("username");
		return usern;	
	}
	public String getPassword() {
		String passw = pro.getProperty("password");
		return passw;
	}
	public String getEmployeeName() {
		String gunadmin=pro.getProperty("employeename");
		return gunadmin;
	}
	
	
}
