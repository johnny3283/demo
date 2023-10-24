package com.manager.model;

import java.util.List;

public class ManagerService {
	private ManagerDAO_interface dao;

	public ManagerService() {
		dao = new ManagerDAO();
	}

	public ManagerVO addMember(String managerName, String managerIp, String managerAccount, String managerPassword) {

		ManagerVO mgrVO = new ManagerVO();
		mgrVO.setManagerName(managerName);
		mgrVO.setManagerIp(managerIp);
		mgrVO.setManagerAccount(managerAccount);
		mgrVO.setManagerPassword(managerPassword);
		

		dao.insert(mgrVO);

		return mgrVO;
	}

	public ManagerVO updateMember(Integer managerNo,String managerAccount,String managerPassword,
							   String managerName, String managerIp,Integer managerStatus) {
		ManagerVO ManagerVO = new ManagerVO();
		ManagerVO.setManagerNo(managerNo);
		ManagerVO.setManagerAccount(managerAccount);
		ManagerVO.setManagerPassword(managerPassword);
		ManagerVO.setManagerName(managerName);
		ManagerVO.setManagerIp(managerIp);
		ManagerVO.setManagerStatus(managerStatus);
		dao.update(ManagerVO);
		return ManagerVO;
	}
	public List<ManagerVO> getAll() {
		return dao.getAll();
	}

	public ManagerVO getOneMember(Integer managerNo) {
		return dao.findByPrimaryKey(managerNo);
	}

	public ManagerVO Login(String managerAccount, String managerPassword) {
		return dao.selectForLogin(managerAccount,managerPassword);
	}	
	public List<Integer> getAuthority(Integer managerNo) {
		return dao.GetAuthority(managerNo);
	}
}
