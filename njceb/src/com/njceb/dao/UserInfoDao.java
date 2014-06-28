package com.njceb.dao;

import java.util.List;

import com.njceb.bean.UserInfo;

public interface UserInfoDao {
	public UserInfo getUserInfo(String userName);
	public List getUsetsList();
	public int updateUserInfo(UserInfo userInfo);
	public int delUserInfo(String userName);
	public int addUserInfo(UserInfo userInfo);
	public int updateUserRole(String userId,String roleId);
}
