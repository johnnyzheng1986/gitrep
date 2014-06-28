package com.njceb.bean;

import java.io.Serializable;

public class News implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4165945092726526745L;
	
	private String newsId;
	private String content;
	private String orgId;
	private String newsTitle;
	
	public News(){}
	
	public News(String newsId, String content, String orgId, String newsTitle) {
		this.newsId = newsId;
		this.content = content;
		this.orgId = orgId;
		this.newsTitle = newsTitle;
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


	
}
