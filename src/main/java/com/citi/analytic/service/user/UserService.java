package com.citi.analytic.service.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citi.analytic.dao.MybatisGenericDao;
import com.citi.analytic.entity.Login;
import com.citi.analytic.entity.User;
import com.citi.analytic.entity.UserCriteria;

public class UserService {

	private MybatisGenericDao<User, UserCriteria> mybatisDao;
	
	private Logger logger=LoggerFactory.getLogger(UserService.class);
	
	public void register(User user) {
//		UserCriteria criteria=new UserCriteria();
//		criteria.createCriteria().andAccountEqualTo(user.getAccount());
//		List<User>list=mybatisDao.selectByCriteria(User.class, criteria);
//		if (list.isEmpty()) {
			int i = mybatisDao.insert(User.class, user);
//			if (i == 1) {
//				logger.info("insert record # {}",i);
//				return true;
//			}			
//		}
//		return false;
	}
	
	public User validateUser(Login login) {
		UserCriteria criteria=new UserCriteria();
		criteria.createCriteria().andAccountEqualTo(login.getAccount()).andPasswordEqualTo(login.getPassword());
		List<User>list=mybatisDao.selectByCriteria(User.class, criteria);
		if (list.size()==1) {
			return list.get(0);
		}
		return null;
	}
	
	public MybatisGenericDao<User, UserCriteria> getMybatisDao() {
		return mybatisDao;
	}

	public void setMybatisDao(MybatisGenericDao<User, UserCriteria> mybatisDao) {
		this.mybatisDao = mybatisDao;
	}


}
