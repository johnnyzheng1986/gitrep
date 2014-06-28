package com.njceb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.njceb.bean.RoleInfo;
import com.njceb.dao.RoleInfoDao;

@Repository
public class RoleInfoDaoImpl extends BaseDaoImpl implements RoleInfoDao {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(RoleInfoDaoImpl.class);

	@Override
	public RoleInfo getRoleInfo(String roleId) {
		// TODO Auto-generated method stub
		String sql = "select * from roleinfo where roleId = '" + roleId + "'";
		List list = jdbcTemplate.query(sql, new RoleInfoRowMapper());
		if (list == null || list.isEmpty()) {
			return null;
		} else {
			return (RoleInfo) list.get(0);
		}
	}

	@Override
	public int updateRoleInfo(RoleInfo roleInfo) {
		String updateSqlString = "update roleinfo set roleName=?,roleDesc=? where roleId=?";
		jdbcTemplate.update(updateSqlString,
				new Object[] { roleInfo.getRoleName(), roleInfo.getRoleDesc(),
						roleInfo.getRoleId() });
		return 0;
	}

	@Override
	public int delRole(String roleId) {
		String deleteSqlString = "delete from roleinfo where roleId = ?";
		jdbcTemplate.update(deleteSqlString, new Object[] { roleId });
		return 0;
	}

	@Override
	public int addRoleInfo(RoleInfo roleInfo) {
		String addSql = "insert into roleinfo (roleName,roleDesc) values (?,?)";

		jdbcTemplate.update(addSql, new Object[] { roleInfo.getRoleName(),
				roleInfo.getRoleDesc() });
		return 0;
	}

	protected class RoleInfoRowMapper implements RowMapper<Object> {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			try {
				RoleInfo roleInfo = new RoleInfo(rs.getString("roleId"),
						rs.getString("roleName"), rs.getString("roleDesc"));
				return roleInfo;
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}

			return null;
		}
	}

	@Override
	public List getRoles() {
		String sqlString ="select * from roleinfo where 1=1";
		List list = jdbcTemplate.query(sqlString, new RoleInfoRowMapper());
		return list;
	}

	@Override
	public List getRolesForUser() {
		String sqlString ="select roleId,roleName from roleinfo where 1=1";
		List list = jdbcTemplate.queryForList(sqlString);
		return list;
	}
}
