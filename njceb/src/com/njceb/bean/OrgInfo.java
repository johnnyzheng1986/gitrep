package com.njceb.bean;

import java.io.Serializable;

public class OrgInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4165945092726526745L;
	
	private String orgId;
	private String orgName;
	private String orgUp;
	public OrgInfo(){}
	
	public OrgInfo(String orgId, String orgName, String orgUp) {
		this.orgId = orgId;
		this.orgName = orgName;
		this.orgUp = orgUp;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgUp() {
		return orgUp;
	}

	public void setOrgUp(String orgUp) {
		this.orgUp = orgUp;
	}

	
}
