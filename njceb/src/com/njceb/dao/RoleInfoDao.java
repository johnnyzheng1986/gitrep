package com.njceb.dao;

import java.util.List;

import com.njceb.bean.RoleInfo;

public interface RoleInfoDao {
	public RoleInfo getRoleInfo(String roleId);
	public int updateRoleInfo(RoleInfo roleInfo);
	public int delRole(String roleId);
	public int addRoleInfo(RoleInfo roleInfo);
	public List getRoles();
	public List getRolesForUser();
}
