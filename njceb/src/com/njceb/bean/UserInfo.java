package com.njceb.bean;

import java.io.Serializable;

public class UserInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4165945092726526745L;
	
	private String userId;
	private String userName;
	private String passWord;
	private String orgId;
	private String orgName;
	private String roleId;
	private String status;
	private String loginIp;
	private String loginTime;
	
	public UserInfo(){}
	
	public UserInfo(String userId, String userName, String passWord,
			String orgId, String orgName, String roleId, String status, String loginIp, String loginTime) {
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.orgId = orgId;
		this.orgName = orgName;
		this.roleId = roleId;
		this.status = status;
		this.loginIp = loginIp;
		this.loginTime = loginTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
