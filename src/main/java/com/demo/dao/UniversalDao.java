package com.demo.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.demo.bean.Pagination;

public interface UniversalDao {

	public <T> void saveEntity(T t);
	
	public <T> void updateEntity(T t);
	
	public <T> T getById(Class<T> clazz, Long id);
	
	public <T> List<T> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults);
	
	public <T> List<T> findByCriteria(DetachedCriteria criteria);
	
	public <T> Long count(Class<T> clazz);
	
	public <T> List<T> findByExample(T exampleEntity, int firstResult, int maxResults);
	
	public <T> void paginationByCriteria(final DetachedCriteria dc, final Pagination page);
	
	public <T> void saveOrUpdate(T entity);
	
	public <T> T merge(T entity);
	
	public <T> int deleteById(final Class<T> clazz, final Long id);
	
}
