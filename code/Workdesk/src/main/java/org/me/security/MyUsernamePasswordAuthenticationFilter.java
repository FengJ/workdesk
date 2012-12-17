package org.me.security;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*
 * MyUsernamePasswordAuthenticationFilter
 attemptAuthentication
 this.getAuthenticationManager()
 ProviderManager.java
 authenticate(UsernamePasswordAuthenticationToken authRequest)
 AbstractUserDetailsAuthenticationProvider.java
 authenticate(Authentication authentication)
 P155 user = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
 DaoAuthenticationProvider.java
 P86 loadUserByUsername
 */
public class MyUsernamePasswordAuthenticationFilter extends
		UsernamePasswordAuthenticationFilter {
	public static final String VALIDATE_CODE = "validateCode";
	public static final String USERNAME = "j_username";
	public static final String PASSWORD = "p_password";

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		System.out.println("MyUsernamePasswordAuthenticationFilter");
		String username = obtainUsername(request);
		String password = obtainPassword(request);
		UserDetails userDetails = userDetailsService
				.loadUserByUsername(username);
		if(userDetails.getUsername() == null){
			throw new UsernameNotFoundException("用户不存在");
		}
		if (password.equals(userDetails.getPassword())) {
			return new UsernamePasswordAuthenticationToken(username,
					userDetails.getPassword());
		}
		throw new BadCredentialsException("Bad Credentials");
	}

	protected void checkValidateCode(HttpServletRequest request) {
	}

	private String obtainValidateCodeParameter(HttpServletRequest request) {
		Object obj = request.getParameter(VALIDATE_CODE);
		return null == obj ? "" : obj.toString();
	}

	protected String obtainSessionValidateCode(HttpSession session) {
		Object obj = session.getAttribute(VALIDATE_CODE);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		Object obj = request.getParameter(USERNAME);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		Object obj = request.getParameter(PASSWORD);
		return null == obj ? "" : obj.toString();
	}

}
