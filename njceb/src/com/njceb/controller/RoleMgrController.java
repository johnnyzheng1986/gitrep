package com.njceb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.njceb.bean.RoleInfo;
import com.njceb.service.RoleInfoService;


@Controller
public class RoleMgrController {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(RoleMgrController.class);

	@Autowired
	private RoleInfoService roleInfoService;

	@RequestMapping(value = "/doGetRoleList.action", method = RequestMethod.POST)
	@ResponseBody
	public List getRoleList() {
		List roleList = roleInfoService.getRoleList();
		return  roleList;
		
	}
	@RequestMapping(value = "/addRole.action", method = RequestMethod.POST, produces = "text/xml;charset=UTF-8")
	@ResponseBody
	public String addRole(@RequestParam(value="roleName") String roleName, @RequestParam(value="roleDesc") String roleDesc) {
		//ID暂时使用自增
		RoleInfo roleInfo = new RoleInfo("",roleName, roleDesc);
		roleInfoService.addRole(roleInfo);
		return  "OK";
		
	}
	@RequestMapping(value = "/updateRole.action", method = RequestMethod.POST, produces = "text/xml;charset=UTF-8")
	@ResponseBody
	public String  updateRole(@RequestParam(value="roleId") String roleId,@RequestParam(value="roleName") String roleName, @RequestParam(value="roleDesc") String roleDesc) {
		RoleInfo roleInfo = new RoleInfo(roleId,roleName, roleDesc);
		roleInfoService.updateRole(roleInfo);
		return  "OK";
	}
	@RequestMapping(value = "/delRole.action", method = RequestMethod.POST)
	@ResponseBody
	public String  delRole(@RequestParam(value="roleId") String roleId) {
		roleInfoService.deleteRole(roleId);
		return  "OK";
	}
	
	
	@RequestMapping(value = "/getRoleForUser.action", method = RequestMethod.POST)
	@ResponseBody
	public List getRoleForUser() {
		List roleList = roleInfoService.getRoleForUser();
		return  roleList;
		
	}
	
}
