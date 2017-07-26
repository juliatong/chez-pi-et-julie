package com.citi.analytic.dao;

import java.util.List;

import com.citi.analytic.domain.Criteria;
import com.citi.analytic.domain.Entity;

public interface GenericDao <E extends Entity, C extends Criteria> {

	
	public int insert(Class<?> c, E e);
	
	public int countByCriteria(Class <?> c, C criteria);
	
	public int deleteByCriteria(Class<?>c, C criteria);
	
	public List<E>selectByCriteria(Class<?>c, C criteria);
	
	public int updateByCriteria(Class<?>c, E entity,C criteria);
	
	public int batchInsert(Class<?>c, List<E> list);
	
	public int saveOrUpdate(Class<?>c, List<E> list, List<String> selectedGroups);

}
