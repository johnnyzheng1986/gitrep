package com.njceb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njceb.bean.News;
import com.njceb.dao.NewsDao;
import com.njceb.service.NewsService;


@Service
@Transactional(rollbackFor = Exception.class)
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsDao newsDao;

	@Override
	public List getNewsList(String pageNum) {
		return newsDao.getNews(pageNum);
	}

	@Override
	public int addNews(News news) {
		newsDao.addNews(news);
		return 0;
	}

	@Override
	public int updateNews(News news) {
		return 0;
	}

	@Override
	public int deleteNews(String newsId) {
		return 0;
	}

	@Override
	public Map<String, Object> getNewsById(String newsId) {
		return newsDao.getNewsById(newsId);
	}

	@Override
	public int getTotalNewsCount() {
		return newsDao.getTotalNewsCount();
	}
	
	
	
}
