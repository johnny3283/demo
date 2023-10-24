package com.authority_detail.model;

import java.io.Serializable;

public class ManagerAuthorityVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer managerNo;
	private Integer authorityNo;
	private String authorityName;

	public Integer getManagerNo() {
		return managerNo;
	}

	public void setManagerNo(Integer managerNo) {
		this.managerNo = managerNo;
	}

	public Integer getAuthorityNo() {
		return authorityNo;
	}

	public void setAuthorityNo(Integer authorityNo) {
		this.authorityNo = authorityNo;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
}
