package com.member.model;


public class MemberVO implements java.io.Serializable{
	private Integer memberNo;
	private String memberAccount;
	private String memberPassword;
	private String memberName;
	private String memberPhone;
	private String memberNickname;
	private String memberAddress;
	private String memberEmail;
	private Integer memberState;
	

///	public MemberVO(Integer member_no,String member_account, String member_password,
//			String member_name, String member_phone, String member_nickname,String member_address,
//			String member_email,Integer member_state) {
//	}
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String membeEmail) {
		this.memberEmail = membeEmail;
	}
	public Integer getMemberState() {
		return memberState;
	}
	public void setMemberState(Integer memberState) {
		this.memberState = memberState;
	}
	

	
	

	
	
}