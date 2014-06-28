package com.njceb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.njceb.bean.DeptInfo;
import com.njceb.dao.DeptInfoDao;

@Repository
public class DeptInfoDaoImpl extends BaseDaoImpl implements DeptInfoDao {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(DeptInfoDaoImpl.class);
	
	@Override
	public List getDetpInfoList() {
		// TODO Auto-generated method stub
		String sqlString = "select orgid, orgname from orginfo where 1=1";
		List list = jdbcTemplate.query(sqlString, new DeptInfoRowMapper());
		return list;
	}

	protected class DeptInfoRowMapper implements RowMapper<Object> {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			try {
				DeptInfo deptInfo = new DeptInfo(String.valueOf(rs.getInt("orgId")), rs.getString("orgName"));
				return deptInfo;
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
			return null;
		}
	}
}
