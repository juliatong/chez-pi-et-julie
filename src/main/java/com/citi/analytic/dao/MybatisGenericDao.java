package com.citi.analytic.dao;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.citi.analytic.dao.mapper.MybatisMapper;
import com.citi.analytic.domain.Criteria;
import com.citi.analytic.domain.Entity;

public class MybatisGenericDao<E extends Entity,C extends Criteria> implements GenericDao<E,C>, InitializingBean{

	private Map<String, MybatisMapper<E,C>> mapperMap;
	private PlatformTransactionManager txManager;

	private static final Logger logger=LoggerFactory.getLogger(MybatisGenericDao.class);
	
	public  MybatisMapper<E, C> getMapper( Class<?>c) {
		String className=c.getName();
		MybatisMapper<E, C> mapper=mapperMap.get(className);
		logger.info("Get mapper for obejct :{}",className);
		return mapper;
	}
	  
	@Override
	public int insert(Class<?> c, E e) {
		int res=getMapper(c).insert(e);
		return res;
	}

	@Override
	public int countByCriteria(Class<?> c, C criteria) {
		int res=getMapper(c).countByCriteria(criteria);
		return res;
	}

	@Override
	public int deleteByCriteria(Class<?> c, C criteria) {
		int res=getMapper(c).deleteByCriteria(criteria);
		return res;
	}

	@Override
	public List<E> selectByCriteria(Class<?> c, C criteria) {
		List<E> list=getMapper(c).selectByCriteria(criteria);
		return list;
	}

	@Override
	public int updateByCriteria(Class<?> c, E record, C criteria) {
		int res=getMapper(c).updateByCriteria(record, criteria);
		return res;
	}

	@Override
	public int batchInsert(Class<?> c, List<E> list) {
		int res=getMapper(c).batchInsert(list);
		return res;
	}

	@Override
	public int saveOrUpdate(Class<?> c, List<E> list, List<String> selectedGroups) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	public Map<String, MybatisMapper<E, C>> getMapperMap() {
		return mapperMap;
	}
	
	public void setMapperMap(Map<String, MybatisMapper<E, C>> mapperMap) {
		this.mapperMap = mapperMap;
	}
	
	public PlatformTransactionManager getTxManager() {
		return txManager;
	}
	
	public void setTxManager(PlatformTransactionManager txManager) {
		this.txManager = txManager;
	}
}
