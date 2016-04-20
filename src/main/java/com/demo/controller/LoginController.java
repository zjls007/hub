package com.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.entity.User;

@Controller
public class LoginController {

	@RequestMapping("/role")
	@ResponseBody
	public Object hasRole(String name) {
		Subject currentUser = SecurityUtils.getSubject();
		System.out.println(currentUser.hasRole(name));
		return currentUser.hasRole(name);
	}
	
	@RequestMapping("/per")
	@ResponseBody
	public Object hasPer(String name) {
		Subject currentUser = SecurityUtils.getSubject();
		System.out.println(currentUser.isPermitted(name));
		return currentUser.isPermitted(name);
	}
	
	@RequestMapping("/signIn")
	public ModelAndView signIn(User user) {
		ModelAndView mav = new ModelAndView("index");
		String status = "";
		Subject currentUser = SecurityUtils.getSubject();
		// 判断用户是否处于登录状态
		if ( !currentUser.isAuthenticated()) {
		    UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
		    token.setRememberMe(true);
		    
		    try {
		        currentUser.login( token );
		    } catch ( UnknownAccountException uae ) {
		    	status = "用户名不正确!";
		    } catch ( IncorrectCredentialsException ice ) {
		    	status = "密码不正确！";
		    } catch ( LockedAccountException lae ) {
		    	status = "用户已被禁用！";
		    } catch ( AuthenticationException ae ) {
		    	status = "无法登录!";
		    }
		}
		if ("".equals(status)) {
			return mav;
		}
		mav.setViewName("redirect:/login");
		mav.addObject("status", status);
		return mav;
	}
}
