package com.njceb.bean;

import java.io.Serializable;

public class News implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4165945092726526745L;
	
	private String newsId;
	private String newsTitle;	
	private String dateTime;	//新闻发布时间
	private String content;		//新闻内容
	private String orgId;	//新闻发布机构
	private String isPost;	//是否发布
	private String isTop;	//是否置顶
	private String changeDateTime;
	
	
	public News(){}
	
	public News(String newsId, String newsTitle, String dateTime, 
			String content,String orgId,String isPost,String isTop,String changeDateTime) {
		this.newsId = newsId;
		this.newsTitle = newsTitle;
		this.dateTime = dateTime;
		this.content = content;
		this.orgId = orgId;
		this.isPost = isPost;
		this.isTop = isTop;
		this.changeDateTime = changeDateTime;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getIsPost() {
		return isPost;
	}

	public void setIsPost(String isPost) {
		this.isPost = isPost;
	}

	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	public String getChangeDateTime() {
		return changeDateTime;
	}

	public void setChangeDateTime(String changeDateTime) {
		this.changeDateTime = changeDateTime;
	}


	
}
