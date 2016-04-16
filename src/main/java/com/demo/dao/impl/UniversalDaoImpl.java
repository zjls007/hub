package com.demo.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.demo.bean.Pagination;
import com.demo.dao.UniversalDao;

@Repository
public class UniversalDaoImpl extends HibernateDaoSupport implements UniversalDao {

	@Autowired
	private void setSF(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	public <T> void saveEntity(T t) {
		getHibernateTemplate().save(t);
	}
	
	public <T> void updateEntity(T t) {
		getHibernateTemplate().save(t);
	}
	
	public <T> T getById(Class<T> clazz, Long id) {
		return getHibernateTemplate().get(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) {
		return (List<T>) getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findByCriteria(DetachedCriteria criteria) {
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}
	
	public <T> Long count(Class<T> clazz) {
		StringBuilder hql = new StringBuilder();
		hql.append("select count(*) from ").append(clazz.getName());
		return (Long) getHibernateTemplate().iterate(hql.toString()).next();
	}
	
	public <T> List<T> findByExample(T exampleEntity, int firstResult, int maxResults) {
		return getHibernateTemplate().findByExample(exampleEntity, firstResult, maxResults);
	}
	
	public <T> void paginationByCriteria(final DetachedCriteria dc,
			final Pagination page) {
		getHibernateTemplate().executeWithNativeSession(new HibernateCallback<T>() {
			@Override
			public T doInHibernate(Session session) throws HibernateException {
				Criteria c = dc.getExecutableCriteria(session);

				page.setTotal(((Long) c.setProjection(Projections.rowCount()).uniqueResult()).longValue());
				c.setProjection(null);
				c.setResultTransformer(Criteria.ROOT_ENTITY);
				c.setFirstResult(page.getFirstResult().intValue());
				c.setMaxResults(page.getMaxResults().intValue());
				page.setCollection(c.list());
				return null;
			}
		});
	}
	
	public <T> void saveOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}
	
	public <T> T merge(T entity) {
		return getHibernateTemplate().merge(entity);
	}
	
	public <T> int deleteById(final Class<T> clazz, final Long id) {
		return getHibernateTemplate().executeWithNativeSession(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				StringBuilder hql = new StringBuilder();
				hql.append("delete from ").append(clazz.getName()).append(" where id = ").append(Long.toString(id));
				Query query = session.createQuery(hql.toString());
				return query.executeUpdate();
			}
		}).intValue();
		
		
	}
	
}
