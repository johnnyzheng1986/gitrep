package com.njceb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njceb.dao.DeptInfoDao;
import com.njceb.service.DeptInfoService;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeptInfoServiceImpl implements DeptInfoService {
	
	@Autowired
	private DeptInfoDao deptInfoDao;
	
	@Override
	public List getDeptInfoList() {
		// TODO Auto-generated method stub
		return deptInfoDao.getDetpInfoList();
	}
	
}
