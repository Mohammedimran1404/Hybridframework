package com.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {
	
	public String getSystemdate() {
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date()); // time stamp
		return timeStamp;

	}

}
