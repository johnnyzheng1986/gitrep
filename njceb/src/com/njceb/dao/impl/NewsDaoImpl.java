package com.njceb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.njceb.bean.News;
import com.njceb.dao.NewsDao;



@Repository
public class NewsDaoImpl extends BaseDaoImpl implements NewsDao {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(NewsDaoImpl.class);

	@Override
	public List getNews(String pageNumString) {
		// 可能需要分页
		int pageNum = Integer.parseInt(pageNumString);
		int pageSize =10;
		int start = pageNum*pageSize;
		int end = (pageNum+1)*pageSize;
		String sql = "select * from  news where 1=1 LIMIT ?,?" ;
		List list = jdbcTemplate.queryForList(sql,new Object[]{start,end});
		if(list == null || list.isEmpty()){
			return null;
		}else{
			return list;
		}
	}

	@Override
	public int updateNews(News news) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delNews(String newsId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addNews(News news) {
		String sql = "insert into news (newsTitle,content) values (?,?)";
		jdbcTemplate.update(sql, new Object[]{news.getNewsTitle(),news.getContent()});
		return 0;
		
	}
	
	protected class NewsRowMapper implements RowMapper<Object> {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			try {
				News news = new News(rs.getString("newsId"),
						rs.getString("content"), rs.getString("orgId"),rs.getString("newsTitle"));
				return news;
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}

			return null;
		}
	}

	@Override
	public Map<String, Object> getNewsById(String newsId) {
		String sqlString ="select * from news where newsId=?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sqlString,new Object[]{newsId});
		return map;
	}

	@Override
	public int getTotalNewsCount() {
		String sql = "select count(*) from news where 1=1";
		int count = jdbcTemplate.queryForInt(sql);
		return count;
	}

}
