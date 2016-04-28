package com.demo.core;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Config {

	public static final String JDBC_URL;
	public static final String JDBC_USERNAME;
	public static final String JDBC_PASSWORD;
	public static final String HIBERNATE_DIALECT;
	public static final String HIBERNATE_SHOWSQL;
	public static final String HIBERNATE_HBMDDL_AUTO;
    
	static {
		ResourceBundle rb = PropertyResourceBundle.getBundle("config");
		
    	JDBC_URL = rb.getString("jdbc.url");
    	JDBC_USERNAME = rb.getString("jdbc.username");
    	JDBC_PASSWORD = rb.getString("jdbc.password");
    	HIBERNATE_DIALECT = rb.getString("hibernate.dialect");
    	HIBERNATE_SHOWSQL = rb.getString("hibernate.show_sql");
    	HIBERNATE_HBMDDL_AUTO = rb.getString("hibernate.hbm2ddl.auto");
	}
	
}
