package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

/**
 *	h2数据库通过web.xml中org.h2.server.web.DbStarter启动
 *  通过H2Console启动数据库web控制台，访问：http://127.0.0.1:[port]/console
 *  
 *  项目通过spring-context.xml中org.h2.jdbcx.JdbcConnectionPool连接数据源
 *  
 *  其它项目通过tcp访问数据库,如下测试
 */
public class H2DbTest {

	@Test
	public void test() throws Exception {
		Class.forName("org.h2.Driver");
		// 这里的端口不是tomcat启动的端口，不要把tomcat的端口写在这里
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/C:/Users/Administrator/git/hub1/test", "sa", "sa");
		System.out.println(conn);
	}
	
}
