package com.njceb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njceb.dao.OrgInfoDao;
import com.njceb.service.OrgInfoService;


@Service
@Transactional(rollbackFor = Exception.class)
public class OrgInfoServiceImpl implements OrgInfoService {
	
	@Autowired
	private OrgInfoDao orgInfoDao;

	@Override
	public List getAllOrgInfo() {
		return orgInfoDao.getAllOrgInfo();
	}
	
}
