package org.me.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public interface CURDService<T> extends Serializable{

	EntityManager getEm();
	
	void add(T obj);

	void addCommit(T obj);

	void delete(T obj);

	void delete(Class<?> cls, Object id);

	List<?> getResultListNative(String sql, Class<?> cls);

	List<?> getResultListNative(String sql);

	T getResultListFirst(String sql);

	T getSingleResultNative(String sql, Class<?> cls);

	List<?> getResultList(String jpql);
	
	List<T> getResultList(String jpql,Class<T> cls);

	Object getSingleResult(String sql);

	int executeSqlNative(String sql);

	int executeSql(String jpql);

	void updateObject(Object obj);

	void updateObjectCommit(Object obj);

	T find(Class<T> cls, String id);

	T findObject(Class<T> cls, Object id);

	void deleteObjectByGuid(String tablename, String fieldname,
			String fieldvalue);

	void commit();

}
