package com.citi.analytic.reference;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryDB {

	public  static Connection getConnection() {
	    String driver = "oracle.jdbc.OracleDriver";
	    String url = "jdbc:oracle:thin:@localhost:1521:UAT";
	    String user = "diamond";
	    String password = "diamond2017";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, user, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
		
	}
}
