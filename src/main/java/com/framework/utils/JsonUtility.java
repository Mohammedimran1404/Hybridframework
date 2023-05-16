package com.framework.utils;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

public class JsonUtility {
//	@DataProvider(name ="jsonhomepage")
	public String jsonDataReader(Object Key) throws IOException, ParseException  {
		//System.out.println("the test cases which has this method"+name.getName()); Method name
		
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(ConstantUtility.jsonFilePath);
		Object obj =jsonparser.parse(reader);
		HashMap map = (HashMap)obj;
		return(String)map.get(Key);
		
		
		
	
	}
	
}