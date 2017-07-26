package com.citi.analytic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.citi.analytic.reference.FactoryDB;
import com.citi.analytic.reference.Student;

public class TestConnection {

	@Test
	public void insert() {
	    Connection conn = FactoryDB.getConnection();
	    int i = 0;
	   Student student= new Student();
	   student.setAge(Integer.valueOf("20"));
	   student.setGender("F");
	   student.setName("JJ");	   
	    String sql = "insert into student (Name,Age,Gender) values(?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, student.getName());
	        pstmt.setInt(2, student.getAge());
	        pstmt.setString(3, student.getGender());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
//	    return i;
	}
}
