package com.citi.analytic.reference;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryDB {

	public  static Connection getConnection() {
	    String driver = "oracle.jdbc.OracleDriver";
//	    String url = "jdbc:oracle:thin:@localhost:1521:UAT";
	    //oracle cloud database service(dbcs) url
	    String url="jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(HOST=129.150.70.18)(PORT=1521)(PROTOCOL=tcp))(CONNECT_DATA=(SERVICE_NAME=PDB1.a512388.oraclecloud.internal)))";
	    String user = "diamond";
//	    String password = "diamond2017";
	    String password ="password123";
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
