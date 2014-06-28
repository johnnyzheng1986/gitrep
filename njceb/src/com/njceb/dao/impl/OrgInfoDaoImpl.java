package com.njceb.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.njceb.bean.OrgInfo;
import com.njceb.dao.OrgInfoDao;


@Repository
public class OrgInfoDaoImpl extends BaseDaoImpl implements OrgInfoDao {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(OrgInfoDaoImpl.class);

	@Override
	public List getAllOrgInfo() {
		// TODO Auto-generated method stub
		String sql = "select orgId id, pOrgId pId,orgName name from  orginfo " ;
		List list = jdbcTemplate.queryForList(sql);
		if(list == null || list.isEmpty()){
			return null;
		}else{
			return list;
		}
	}

	@Override
	public int delOrgInfo(String orgId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addOrgInfo(OrgInfo orgInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOrg(OrgInfo orgInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	

//
//	protected class UserInfoRowMapper implements RowMapper<Object> {
//
//		@Override
//		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//			// TODO Auto-generated method stub
//			try {
//				UserInfo userInfo = new UserInfo(rs.getString("userName"),
//						rs.getString("passWord"), rs.getString("deptName"),
//						rs.getString("loginIp"), rs.getString("loginTime"));
//				return userInfo;
//			} catch (Exception e) {
//				e.printStackTrace();
//				log.error(e);
//			}
//			
//			return null;
//		}
//	}
}
