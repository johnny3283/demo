package com.manager.model;
import java.util.List;

public class ManagerVO implements java.io.Serializable{
	private Integer managerNo;
	private String managerName;
	private String managerIp;
	private String managerAccount;
	private String managerPassword;
	private Integer managerStatus;
	private String authorityName;
	private List<Integer> authorityNo;
	
	public Integer getManagerNo() {
		return managerNo;
	}
	public void setManagerNo(Integer managerNo) {
		this.managerNo = managerNo;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerIp() {
		return managerIp;
	}
	public void setManagerIp(String managerIp) {
		this.managerIp = managerIp;
	}
	public String getManagerAccount() {
		return managerAccount;
	}
	public void setManagerAccount(String managerAccount) {
		this.managerAccount = managerAccount;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	public Integer getManagerStatus() {
		return managerStatus;
	}
	public void setManagerStatus(Integer managerStatus) {
		this.managerStatus = managerStatus;
	}
	public List<Integer> getAuthorityNo() {
		return authorityNo;
	}
	public void setAuthorityNo(List<Integer> authorityNo) {
		this.authorityNo = authorityNo;
	}


	

	
	

	
	
}