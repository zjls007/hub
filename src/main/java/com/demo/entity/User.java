package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="app_user")
public class User extends BaseEntity {

	/**
	 * 账号是否被禁用
	 */
	private boolean locked;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 登录次数
	 */
	private String loginCount;
	
	/**
	 * 最后登录时间
	 */
	private String lastLoginTime;

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(String loginCount) {
		this.loginCount = loginCount;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
}
