package com.njceb.service;

import java.util.List;
import java.util.Map;


import com.njceb.bean.News;


public interface NewsService {
	
	public List getNewsList(String pageNum);
	public int  addNews(News news);
	public int  updateNews(News news);
	public int  deleteNews(String newsId);
	public Map<String, Object> getNewsById(String newsId);
	public int  getTotalNewsCount();
}
