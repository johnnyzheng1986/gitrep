package com.njceb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.njceb.bean.UserInfo;
import com.njceb.dao.UserInfoDao;

@Repository
public class UserInfoDaoImpl extends BaseDaoImpl implements UserInfoDao {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(UserInfoDaoImpl.class);

	@Override
	public UserInfo getUserInfo(String userName) {
		String sql = "select u.userid, u.username, u.password, u.orgid, o.orgname, u.roleid, u.status, u.loginip, u.logintime from userinfo u left join orginfo o on u.orgid = o.orgid where u.username = '" + userName + "'";
		log.info("查询用户SQL语句：["+sql+"]");
		List list = jdbcTemplate.query(sql, new UserInfoRowMapper());
		if(list == null || list.isEmpty()){
			return null;
		}else{
			return (UserInfo) list.get(0);
		}
	}

	@Override
	public int updateUserInfo(UserInfo userInfo) {
		return 0;
	}

	@Override
	public int delUserInfo(String userName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addUserInfo(UserInfo userInfo) {
		String sql = "insert into userinfo(username, password, orgid, status) values('"+userInfo.getUserName()+"','"+userInfo.getPassWord()+"','"+userInfo.getOrgId()+"','1')";
		log.info("插入新用户：["+sql+"]");
		return jdbcTemplate.update(sql);
	}

	@Override
	public List getUsetsList() {
		String sqlString = "select * from  userinfo where 1=1";
		List list = jdbcTemplate.queryForList(sqlString);
		return list;
	}

	@Override
	public int updateUserRole(String userId, String roleId) {
		String sqlString ="update userinfo set roleId=? where userId=?";
		jdbcTemplate.update(sqlString,new Object[]{roleId,userId});
		return 0;
	}

	protected class UserInfoRowMapper implements RowMapper<Object> {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			try {
				UserInfo userInfo = new UserInfo(rs.getString("userId"),rs.getString("userName"),
						rs.getString("passWord"), rs.getString("orgId"), rs.getString("orgname"),
						rs.getString("roleId"),rs.getString("status"),
						rs.getString("loginIp"), rs.getString("loginTime"));
				return userInfo;
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
			return null;
		}
	}
}
