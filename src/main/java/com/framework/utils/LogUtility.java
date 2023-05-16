package com.framework.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtility {
	Logger logger = LogManager.getLogger(LogUtility.class);
	public void info(String message) {
		logger.info(message);
	}
	public void pass(String message) {
		logger.info(message);
	}
	public void fail(String message) {
		logger.error(message);
		
	}
	
		
	}

	
	


