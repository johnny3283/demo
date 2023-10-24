package com.authority_detail.model;

import java.util.List;

public class AuthorityDetailService {
	private AuthorityDetailDAO_interface dao;

	public AuthorityDetailService() {
		dao = new AuthorityDetailJDBCDAO();
	}

	public void save(AuthorityDetailVO authorityDetailVO) {
		dao.insert(authorityDetailVO);
	}

	public void updateAuthority_detail(AuthorityDetailVO authorityDetailVO) {
		dao.update(authorityDetailVO);
	}

	public void deleteAuthority_detail(AuthorityDetailVO authorityDetailVO) {
		dao.delete(authorityDetailVO);
	}

	public List<ManagerAuthorityVO> getoneAuthority_detail(Integer managerNo) {
		return dao.findByManagerNo(managerNo);
	}

	public List<AuthorityDetailVO> getAll() {
		return dao.getAll();
	}
}
