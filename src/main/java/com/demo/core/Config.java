package com.demo.core;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Config {

	public static String JDBC_URL = "jdbc.url";
	public static String JDBC_USERNAME = "jdbc.username";
	public static String JDBC_PASSWORD = "jdbc.password";
	public static String HIBERNATE_DIALECT = "hibernate.dialect";
	public static String HIBERNATE_SHOWSQL = "hibernate.show_sql";
	public static String HIBERNATE_HBMDDL_AUTO = "hibernate.hbm2ddl.auto";
    
	static {
		ResourceBundle rb = PropertyResourceBundle.getBundle("config");
		
    	JDBC_URL = rb.getString(JDBC_URL);
    	JDBC_USERNAME = rb.getString(JDBC_USERNAME);
    	JDBC_PASSWORD = rb.getString(JDBC_PASSWORD);
    	HIBERNATE_DIALECT = rb.getString(HIBERNATE_DIALECT);
    	HIBERNATE_SHOWSQL = rb.getString(HIBERNATE_SHOWSQL);
    	HIBERNATE_HBMDDL_AUTO = rb.getString(HIBERNATE_HBMDDL_AUTO);
	}
	
}
