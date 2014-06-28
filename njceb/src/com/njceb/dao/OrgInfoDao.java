package com.njceb.dao;

import java.util.List;

import com.njceb.bean.OrgInfo;

public interface OrgInfoDao {
	public List getAllOrgInfo();
	public int updateOrg(OrgInfo orgInfo);
	public int delOrgInfo(String orgId);
	public int addOrgInfo(OrgInfo orgInfo);
}
