package com.github.analytic.dao;

import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class AbstractBaseDao {

	private static final Logger logger=LoggerFactory.getLogger(AbstractBaseDao.class);
	
	public Map<String, String> sqlMap;
	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;
	
	
	public Map<String, String> getSqlMap() {
		return sqlMap;
	}		
	public void setSqlMap(Map<String, String> sqlMap) {
		this.sqlMap = sqlMap;
	}
	
	public DataSource getDatasource() {
		return datasource;
	}
	public void setDatasource(DataSource dataSource) {
		this.datasource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public String getSql(String id) {
		return this.sqlMap.get(id);
	}	
}
