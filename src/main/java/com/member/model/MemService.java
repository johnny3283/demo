package com.member.model;

import java.util.List;
public class MemService {
	private MemberDAO_interface dao;

	public MemService() {
		dao = new MemberDAO();
	}

	public MemberVO addMember(String memberAccount, String memberPassword, String memberName, String memberPhone,
			String memberNickname, String memberAddress, String memberEmail) {

		MemberVO MemberVO = new MemberVO();
		MemberVO.setMemberAccount(memberAccount);
		MemberVO.setMemberPassword(memberPassword);
		MemberVO.setMemberName(memberName);
		MemberVO.setMemberPhone(memberPhone);
		MemberVO.setMemberNickname(memberNickname);
		MemberVO.setMemberAddress(memberAddress);
		MemberVO.setMemberEmail(memberEmail);

		dao.insert(MemberVO);

		return MemberVO;
	}

	public MemberVO updateMember(String memberAccount, Integer memberNo, String memberPassword, String memberName, String memberPhone,
			String memberNickname, String memberAddress, String memberEmail) {
		MemberVO MemberVO = new MemberVO();
		MemberVO.setMemberAccount(memberAccount);
		MemberVO.setMemberNo(memberNo);
		MemberVO.setMemberPassword(memberPassword);
		MemberVO.setMemberName(memberName);
		MemberVO.setMemberPhone(memberPhone);
		MemberVO.setMemberNickname(memberNickname);
		MemberVO.setMemberAddress(memberAddress);
		MemberVO.setMemberEmail(memberEmail);
		dao.mngMember(MemberVO);
		return MemberVO;
	}
	

	public MemberVO mngMember(Integer memberNo, String memberName, String memberPhone, String memberNickname,
			String memberAddress, String memberEmail, Integer memberState) {
		MemberVO MemberVO = new MemberVO();
		MemberVO.setMemberNo(memberNo);
		MemberVO.setMemberName(memberName);
		MemberVO.setMemberPhone(memberPhone);
		MemberVO.setMemberNickname(memberNickname);
		MemberVO.setMemberAddress(memberAddress);
		MemberVO.setMemberEmail(memberEmail);
		MemberVO.setMemberState(memberState);
		dao.update(MemberVO);
		return MemberVO;
	}

	public void deleteMember(Integer empno) {
		dao.delete(empno);
	}

	public List<MemberVO> getAll() {
		return dao.getAll();
	}

	public MemberVO getOneMember(Integer memberNo) {
		return dao.findByPrimaryKey(memberNo);
	}

	public MemberVO Login(String memberAccount, String memberPassword) {
		return dao.selectForLogin(memberAccount, memberPassword);
	}
	public MemberVO findByAccount(String memberAccount) {
		return dao.findByAccount(memberAccount);
	}
	public MemberVO findByEmail(String memberEmail) {
		return dao.findByEmail(memberEmail);
	}

	public MemberVO getOnePhyCourse(Integer memberNo) {
		return dao.findByPrimaryKey(memberNo);
	}
	public MemberVO getOneOnlineCourse(Integer memberNo) {
		return dao.findByPrimaryKey(memberNo);
	}

}
