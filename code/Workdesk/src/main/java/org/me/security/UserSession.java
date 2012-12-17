package org.me.security;

import java.util.Collection;

import org.me.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component("userSession")
@Scope("session")
public class UserSession implements UserDetails{
	
	private static final long serialVersionUID = -8854289766690216254L;
	
	private Collection<GrantedAuthority> auths;
	
	private String username;
	
	private String password;
	
	public void buildUserSession(User u){
		this.username = u.getUsername();
		this.password = u.getPassword();
	}
	
	public void buildUserSession(Collection<GrantedAuthority> auths){
		this.auths = auths;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return auths;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
