package com.citi.analytic.dao.mapper;

import java.util.List;


import com.citi.analytic.domain.Criteria;
import com.citi.analytic.domain.Entity;
import com.citi.analytic.entity.User;

public interface MybatisMapper<E extends Entity , C extends Criteria> {

	public int insert(E e);


	public int countByCriteria(C criteria);


	public int deleteByCriteria(C criteria);

	
	public List<E> selectByCriteria(C criteria) ;


	public int updateByCriteria(E entity, C criteria) ;


	public int batchInsert(List<E> list) ;


	public int saveOrUpdate( List<E> list, List<String> selectedGroups) ;

    public int updateByPrimaryKey(E entity);


}
