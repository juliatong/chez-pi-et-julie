package com.github.analytic.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.analytic.business.FactoryDB;
import com.github.analytic.business.Tea;

public class TestConnection {

	private Logger logger=LoggerFactory.getLogger(TestConnection.class);

	@Test
	private  Integer getAll(){
		Connection connection = FactoryDB.getConnection();
		String sql = "select * from tea";
		PreparedStatement statement;
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			int count = resultSet.getMetaData().getColumnCount();
			logger.info("execute++++++==");
			while (resultSet.next()) {
				for (int i = 0; i < count; i++) {
					logger.info(resultSet.getString(i) + "\t");
				}
				logger.info("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private int insert(Tea tea){
		Connection connection=FactoryDB.getConnection();
		int i=0;
		String sql="insert into tea-----";
		PreparedStatement statement;
		try {
			statement=(PreparedStatement)connection.prepareStatement(sql);
			statement.setString(1, tea.getId());
			statement.setString(2, tea.getName());
			statement.setString(3, tea.getColour());
			i=statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		
	}
	
	private int update(Tea tea){		
		Connection connection=FactoryDB.getConnection();
		int i=0;
		String sql="";
		PreparedStatement statement;
		try {
			statement=(PreparedStatement)connection.prepareStatement(sql);
			i=statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
}
