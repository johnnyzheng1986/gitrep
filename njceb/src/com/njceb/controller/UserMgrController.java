package com.njceb.controller;

import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.njceb.bean.UserInfo;
import com.njceb.service.UserInfoService;



@Controller
public class UserMgrController {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(UserMgrController.class);

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value = "/getUserList.action", method = RequestMethod.POST)
	@ResponseBody
	public List getUserList() {
		List userList = userInfoService.getUsersList();
		return  userList;
		
	}
//	@RequestMapping(value = "/addUser.action", method = RequestMethod.POST)
//	@ResponseBody
//	public String addRole(@RequestParam(value="userName") String userName, @RequestParam(value="roleId") String roleId) {
//		//ID暂时使用自增
//		UserInfo userInfo = new UserInfo("",userName,"","", roleId,"","","");
//		UserInfoService.addUser(userInfo);
//		return  "OK";
//		
//	}
	@RequestMapping(value = "/updateUserRole.action", method = RequestMethod.POST)
	@ResponseBody
	public String  updateRole(@RequestParam(value="userId") String userId,@RequestParam(value="userName") String userName, @RequestParam(value="roleId") String roleId) {
//		UserInfo userInfo = new UserInfo(userId,userName,"","", roleId,"","","");
		userInfoService.updateUserRole(userId, roleId);
		return  "OK";
	}
//	@RequestMapping(value = "/delUser.action", method = RequestMethod.POST)
//	@ResponseBody
//	public String  delUser(@RequestParam(value="userId") String userId) {
//		userInfoService.deleteUser(userId);
//		return  "OK";
//	}
	
}
