package com.njceb.service;

import java.util.List;


import com.njceb.bean.RoleInfo;


public interface RoleInfoService {
	
	public List  getRoleList();
	public int  addRole(RoleInfo roleInfo);
	public int  updateRole(RoleInfo roleInfo);
	public int  deleteRole(String roleId);
	
	public List  getRoleForUser();
}
