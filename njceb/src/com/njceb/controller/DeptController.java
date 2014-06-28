package com.njceb.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.njceb.bean.DeptInfo;
import com.njceb.service.DeptInfoService;

@Controller
public class DeptController {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(DeptController.class);

	@Autowired
	private DeptInfoService deptInfoService;

	@RequestMapping(value = "/queryDeptInfoList.action", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<DeptInfo> queryDeptInfoList() {
		try {
			return deptInfoService.getDeptInfoList();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		
		return null;
	}

	public static void main(String args[]) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EE");
		String loginTime = df.format(new Date());
		log.info("==============µÇÂ¼Ê±¼ä===============[" + loginTime + "]");
	}
}
