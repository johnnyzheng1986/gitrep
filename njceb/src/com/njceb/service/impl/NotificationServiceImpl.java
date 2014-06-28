package com.njceb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njceb.dao.NotificationDao;
import com.njceb.service.NotificationService;

@Service
@Transactional(rollbackFor = Exception.class)
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	private NotificationDao notificationDao;
	
	@Override
	public List getNotificationList(String userName) {
		// TODO Auto-generated method stub
		return notificationDao.getNotificationList(userName);
	}
	
}
