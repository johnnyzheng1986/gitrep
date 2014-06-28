package com.njceb.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoImpl {
	
	private static org.apache.log4j.Logger log = Logger.getLogger(BaseDaoImpl.class);
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
}
