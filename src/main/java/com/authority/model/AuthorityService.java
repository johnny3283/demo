package com.authority.model;

import java.util.List;

public class AuthorityService {
	private AuthorityDAO_interface dao;

	public AuthorityService() {
		dao = new AuthorityJDBCDAO();
	}

	public void save(AuthorityVO authorityVO) {
		dao.insert(authorityVO);
	}

	public void updateAuthorityDetail(AuthorityVO authorityVO) {
		dao.update(authorityVO);

	}

	public void deleteAuthorityDetail(AuthorityVO authorityVO) {
		dao.delete(authorityVO);
	}

	public AuthorityVO getOneAuthorityDetail(Integer authorityNo) {
		return dao.findByPrimaryKey(authorityNo);
	}

	public List<AuthorityVO> getAll() {
		return dao.getAll();
	}

}
