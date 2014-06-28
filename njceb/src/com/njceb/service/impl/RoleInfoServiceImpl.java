package com.njceb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njceb.bean.RoleInfo;
import com.njceb.dao.RoleInfoDao;
import com.njceb.service.RoleInfoService;


@Service
@Transactional(rollbackFor = Exception.class)
public class RoleInfoServiceImpl implements RoleInfoService {
	
	@Autowired
	private RoleInfoDao roleInfoDao;

	@Override
	public List getRoleList() {
		return roleInfoDao.getRoles();
	}

	@Override
	public int addRole(RoleInfo roleInfo) {
		return roleInfoDao.addRoleInfo(roleInfo);
		
	}

	@Override
	public int updateRole(RoleInfo roleInfo) {
		roleInfoDao.updateRoleInfo(roleInfo);
		return 0;
	}

	@Override
	public int deleteRole(String roleId) {
		roleInfoDao.delRole(roleId);
		return 0;
	}

	@Override
	public List getRoleForUser() {
		return roleInfoDao.getRolesForUser();
	}
}
