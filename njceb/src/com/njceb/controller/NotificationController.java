package com.njceb.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.njceb.service.NotificationService;
import com.njceb.service.UserInfoService;

@Controller
public class NotificationController {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(NotificationController.class);

	@Autowired
	private NotificationService notificationService;

	@RequestMapping(value = "/queryNotification.action", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public Map queryNotification(HttpSession session) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EE");
			String userName = (String)session.getAttribute("LOGIN_USER");
			log.info("查询通知请求[" + df.format(new Date()) + "],USERNAME=["
					+ userName + "]");
			Map<String, Object> result = new HashMap<String, Object>(2);
			List list = notificationService.getNotificationList(userName);
			result.put("total", list.size()); 
			result.put("rows", list);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		
		return null;
	}
}
