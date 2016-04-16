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

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		Subject currentUser = SecurityUtils.getSubject();
		
		if ( !currentUser.isAuthenticated()  || true) {
		    //collect user principals and credentials in a gui specific manner 
		    //such as username/password html form, X509 certificate, OpenID, etc.
		    //We'll use the username/password example here since it is the most common.
		    //(do you know what movie this is from? ;)
		    UsernamePasswordToken token = new UsernamePasswordToken("zxj", "1232");
		    //this is all you have to do to support 'remember me' (no config - built in!):
		    token.setRememberMe(true);
		    
		    try {
		        currentUser.login( token );
		        //if no exception, that's it, we're done!
		    } catch ( UnknownAccountException uae ) {
		    	System.out.println(1);
		    	
		        //username wasn't in the system, show them an error message?
		    } catch ( IncorrectCredentialsException ice ) {
		    	System.out.println(2);
		        //password didn't match, try again?
		    } catch ( LockedAccountException lae ) {
		    	System.out.println(3);
		        //account for that username is locked - can't login.  Show them a message?
		    } 
		     catch ( AuthenticationException ae ) {
		    	 System.out.println(4);
		        //unexpected condition - error?
		    }
		}
		return "index";
	}
	
}
