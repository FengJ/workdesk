package org.me.security;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.context.HttpSessionContextIntegrationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/security")
public class AjaxLoginController {
	
	@Resource(name="myAuthenticationProvider")
	private AuthenticationProvider am;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> login(HttpServletRequest request,
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		System.out.println(username);
		Map<String, String> map = new HashMap<String, String>();
		try {
			Authentication auth = new UsernamePasswordAuthenticationToken(
					username, password);
			Authentication result = am.authenticate(auth);
			if(result != null){
				HttpSession session = request.getSession(true);
				session.setAttribute("UID", username);
			}
			SecurityContextHolder.getContext().setAuthentication(result);
			map.put("success", "true");
			map.put("errormsg", "登录成功");
			return map;
		} catch (BadCredentialsException e) {
			map.put("success", "false");
			map.put("errormsg", "登录验证失败");
		} catch (UsernameNotFoundException e) {
			map.put("success", "false");
			map.put("errormsg", "用户不存在");
		}
		return map;
	}
}
