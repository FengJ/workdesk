package org.me.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.me.dao.CURDService;
import org.springframework.stereotype.Repository;

@Repository
public class CURDServiceImpl<T> implements CURDService<T> {

	private static final long serialVersionUID = -1030963214660572793L;
	@PersistenceContext
	private EntityManager em;

	public void add(T obj) {
		this.em.persist(obj);
	}

	public void addCommit(T obj) {
		this.em.persist(obj);
		this.em.flush();
	}

	public void delete(Class<?> cls, Object id) {
		this.em.remove(this.em.merge(this.em.find(cls, id)));
	}

	public void delete(T obj) {
		this.em.remove(this.em.merge(obj));
	}

	public List<?> getResultListNative(String sql, Class<?> cls) {
		return this.em.createNativeQuery(sql, cls).getResultList();
	}

	public List<?> getResultListNative(String sql) {
		return this.em.createNativeQuery(sql).getResultList();
	}

	@SuppressWarnings("unchecked")
	public T getResultListFirst(String sql) {
		List<?> oList = this.em.createQuery(sql).getResultList();
		if (oList.size() > 0) {
			return (T) oList.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public T getSingleResultNative(String sql, Class<?> cls) {
		List<?> oList = this.em.createNativeQuery(sql, cls).getResultList();
		if (oList.size() > 0) {
			return (T) oList.get(0);
		}

		return null;
	}

	public List<?> getResultList(String jpql) {
		return this.em.createQuery(jpql).getResultList();
	}
	
	public List<T> getResultList(String jpql,Class<T> cls) {
		return this.em.createQuery(jpql,cls).getResultList();
	}

	public Object getSingleResult(String sql) {
		List<?> oList = this.em.createQuery(sql).getResultList();
		if (oList.size() > 0) {
			return oList.get(0);
		}

		return null;
	}

	public int executeSqlNative(String sql) {
		return this.em.createNativeQuery(sql).executeUpdate();
	}

	public int executeSql(String jpql) {
		return em.createNativeQuery(jpql).executeUpdate();
	}

	public void updateObject(Object obj) {
		this.em.merge(obj);
	}

	public void updateObjectCommit(Object obj) {
		this.em.merge(obj);
		this.em.flush();
	}

	public T find(Class<T> cls, String id) {
		Object obj = this.em.find(cls, id);
		return cls.cast(obj);
	}

	public T findObject(Class<T> cls, Object id) {
		Object obj = this.em.find(cls, id);
		return cls.cast(obj);
	}

	public void deleteObjectByGuid(String tablename, String fieldname,
			String fieldvalue) {
		String sql = "delete from " + tablename + " where " + fieldname + "='"
				+ fieldvalue + "'";
		this.em.createNativeQuery(sql).executeUpdate();
	}
	@Override
	public void commit(){
		this.em.flush();
	}

	@Override
	public EntityManager getEm() {
		return em;
	}

}
