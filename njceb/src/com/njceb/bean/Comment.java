package com.njceb.bean;

import java.io.Serializable;

public class Comment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String commentId;//评论ID
	private String newsId;	//新闻ID
	private String userId;	//用户ID
	private String upUserId;	//点赞用户ID
	private String upCount;	//点赞数目
	private String downUserId;	//反对用户ID
	private String downCount;	//反对数目
	private String content;	//评论内容
	
	public Comment(){}
	

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


	public String getCommentId() {
		return commentId;
	}


	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUpUserId() {
		return upUserId;
	}


	public void setUpUserId(String upUserId) {
		this.upUserId = upUserId;
	}


	public String getUpCount() {
		return upCount;
	}


	public void setUpCount(String upCount) {
		this.upCount = upCount;
	}


	public String getDownUserId() {
		return downUserId;
	}


	public void setDownUserId(String downUserId) {
		this.downUserId = downUserId;
	}


	public String getDownCount() {
		return downCount;
	}


	public void setDownCount(String downCount) {
		this.downCount = downCount;
	}



	
}
