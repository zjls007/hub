package com.demo.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class Log4j2Test {
	
	Logger logger = LogManager.getLogger(Log4j2Test.class);
	Logger a = LogManager.getLogger(A.class);
	Logger b = LogManager.getLogger(B.class);

	@Test
	public void test() throws Exception {
		for (int i = 0; i < 1000; i++) {
//			logger.info("a{}","c");
			a.info("a{}","c");
//			b.info("a{}","c");
		}
		
	}
	
}
