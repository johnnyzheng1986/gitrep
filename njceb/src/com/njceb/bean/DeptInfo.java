package com.njceb.bean;

import java.io.Serializable;

public class DeptInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -535348594377877334L;
	
	private String detpId;
	private String detpName;
	
	public DeptInfo(){}
	
	public DeptInfo(String detpId, String detpName) {
		this.detpId = detpId;
		this.detpName = detpName;
	}

	public String getDetpId() {
		return detpId;
	}

	public void setDetpId(String detpId) {
		this.detpId = detpId;
	}

	public String getDetpName() {
		return detpName;
	}

	public void setDetpName(String detpName) {
		this.detpName = detpName;
	}
}
