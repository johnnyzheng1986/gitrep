package com.njceb.service;

import java.util.List;

import com.njceb.bean.UserInfo;

public interface UserInfoService {
	
	public UserInfo getUserInfo(String userName);
	public List  getUsersList();
	public int  addUser(UserInfo userInfo);
	public int  updateUser(UserInfo userInfo);
	public int  deleteUser(String userId);
	public int  updateUserRole(String userId,String roleId);
}
