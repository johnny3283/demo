package com.authority.model;

import java.io.Serializable;

public class AuthorityVO implements Serializable {
	private Integer authorityNo;
	private String authorityName;

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
