package com.njceb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njceb.bean.UserInfo;
import com.njceb.dao.UserInfoDao;
import com.njceb.service.UserInfoService;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public UserInfo getUserInfo(String userName) {
		return userInfoDao.getUserInfo(userName);
	}

	@Override
	public List getUsersList() {
		return userInfoDao.getUsetsList();
	}
	
	@Override
	public int addUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userInfoDao.addUserInfo(userInfo);
	}

	@Override
	public int updateUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUserRole(String userId, String roleId) {
		userInfoDao.updateUserRole(userId, roleId);
		return 0;
	}
	
}
