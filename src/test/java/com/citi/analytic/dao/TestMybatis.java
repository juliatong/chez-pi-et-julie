package com.citi.analytic.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.citi.analytic.domain.Criteria;
import com.citi.analytic.domain.Entity;
import com.citi.analytic.entity.User;

public class TestMybatis {

	@Test
	public void insert() {
		ApplicationContext context=new ClassPathXmlApplicationContext("mybatis/mybatis-generic-dao.xml");
		MybatisGenericDao<Entity, Criteria> mybatisDao=(MybatisGenericDao)context.getBean("mybatisGenericDao");
		User instance=new User();
	//888999	instance.setUserId("111");
		instance.setAddress("aa");
		instance.setEmail("###");
		instance.setFirstname("jj");
		instance.setLastname("dd");
		instance.setPassword("TT");
		instance.setPhone("001");
		instance.setType("100");
		instance.setAccount("647ghd");
		instance.setZipcode("9432743");
		mybatisDao.insert(User.class, instance);
	}
}

