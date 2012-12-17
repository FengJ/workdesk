package org.me.dao.impl;

import javax.annotation.Resource;

import org.me.dao.CURDService;
import org.me.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {

	@Resource
	private CURDService<User> curd;
	
	public User getUserByEmail(String email){
		String hql = " from User t where t.email='"+email+"'";
		return curd.getResultListFirst(hql);
	}
}
