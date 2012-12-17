package org.me.security;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("myAuthenticationProvider")
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Resource
	UserDetailsService userDetailsService;
	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(auth
				.getName());
		if (userDetails.getUsername() == null) {
			throw new UsernameNotFoundException("用户不存在");
		}
		if (auth.getCredentials().toString().equals(userDetails.getPassword())) {
			return new UsernamePasswordAuthenticationToken(auth.getName(),
					userDetails.getPassword(), userDetails.getAuthorities());
		}
		throw new BadCredentialsException("Bad Credentials");
	}

	@Override
	public boolean supports(Class<? extends Object> auth) {
		return false;
	}
}
