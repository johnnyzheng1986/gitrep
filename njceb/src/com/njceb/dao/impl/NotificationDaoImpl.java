package com.njceb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.njceb.bean.Notification;
import com.njceb.bean.UserInfo;
import com.njceb.dao.NotificationDao;
import com.njceb.dao.UserInfoDao;

@Repository
public class NotificationDaoImpl extends BaseDaoImpl implements NotificationDao {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(NotificationDaoImpl.class);
	
	@Override
	public List getNotificationList(String userName) {
		// TODO Auto-generated method stub
		String sqlString = "select * from news where 1=1";
		List list = jdbcTemplate.queryForList(sqlString);
		return list;
	}

	protected class UserInfoRowMapper implements RowMapper<Object> {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			try {
				Notification notification = new Notification(rs.getString("title"), rs.getString("content"), rs.getString("dateIssued"));
				return notification;
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
			return null;
		}
	}
}
