package com.github.analytic.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryDB {

	public static Connection getConnection(){
		String driver="";
		String url="";
		String user="";
		String password="";
		Connection connection=null;
		try {
			Class.forName(driver);
			connection=(Connection)DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
