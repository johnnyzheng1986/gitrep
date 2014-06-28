package com.njceb.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.njceb.service.OrgInfoService;

@Controller
public class OrgInfoController {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(OrgInfoController.class);

	@Autowired
	private OrgInfoService orgInfoService;

	@RequestMapping(value = "/doGetOrgTree.action", method = RequestMethod.POST)
	@ResponseBody
	public List getAllOrgInfo() {
		List orginfolist = orgInfoService.getAllOrgInfo();
		for (Iterator iterator = orginfolist.iterator(); iterator.hasNext();) {
			Map<String, String> orginfo = (Map<String, String>) iterator.next();
			orginfo.put("open", "true");
		}
		return  orginfolist;
		
//		return JSONArray.fromObject(orginfoTree).toString();
//		Map<String, Object> result = new HashMap<String, Object>(2);
//		
//		result.put("total", orginfolist.size()); 
//		result.put("rows", orginfolist);
//        return result;
	}


	@RequestMapping(value = "/getOrgList.action", method = RequestMethod.POST)
	@ResponseBody
	public List getAllOrg() {
		List orginfolist = orgInfoService.getAllOrgInfo();
		return  orginfolist;
		
	}
}
