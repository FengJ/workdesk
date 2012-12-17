package org.me.security;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.me.dao.impl.UserService;
import org.me.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailServiceImpl implements UserDetailsService {

	@Resource
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		System.out.println(username + "~~~~~~~~~getUserDetails");
		User user = userService.getUserByEmail(username);
		if(user == null){
			throw new UsernameNotFoundException("用户不存在");
		}
		UserSession userSession = new UserSession();
		userSession.buildUserSession(user);
		userSession.buildUserSession(obtionGrantedAuthorities(user));
		return userSession;
	}

	// 取得用户的权限
	private Set<GrantedAuthority> obtionGrantedAuthorities(User user) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		return authSet;
	}
}
