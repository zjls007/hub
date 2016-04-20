package com.demo.core;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.entity.User;
import com.demo.service.UserService;

/**
 * @author Administrator shiro的dao操作类
 */
@Component("shiroDbRealm")
public class ShiroDbRealm extends AuthorizingRealm {

	@Autowired
	UserService userService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.
	 * apache.shiro.authc.AuthenticationToken) 身份验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// 获取登录信息
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		String username = token.getUsername();

		User user = userService.getUserByUserName(username);
		if (user != null) {
			if (user.isLocked()) {
				// 用户被禁用
				throw new LockedAccountException();
			}
			// 参数是需要验证的对象, 证明身份的证书, 验证Realm名称
			return new SimpleAuthenticationInfo(username, user.getPassword(), getName());
		}
		// A null return value means that no account could be associated with
		// the specified token.
		// 返回null表示不存在当前用户
		return null;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//		String loginName = (String) getAvailablePrincipal(principalCollection);
		String loginName = (String) principalCollection.getPrimaryPrincipal();
		System.out.println("userName: ->" + loginName);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> roles = new HashSet<String>();
		roles.add("admin");
		info.setRoles(roles);

		info.addStringPermission("add");
		info.addStringPermission("see");
		info.addStringPermission("del");
		
		return info;
	}
	
}
