package com.authority_detail.model;

import java.io.Serializable;

public class AuthorityDetailVO implements Serializable {
	private Integer mangerNo;
	private Integer authorityNo;

	public Integer getMangerNo() {
		return mangerNo;
	}

	public void setMangerNo(Integer mangerNo) {
		this.mangerNo = mangerNo;
	}

	public Integer getAuthorityNo() {
		return authorityNo;
	}

	public void setAuthorityNo(Integer authorityNo) {
		this.authorityNo = authorityNo;
	}

}
