package com.authority_detail.model;

import java.util.List;

public interface AuthorityDetailDAO_interface {
	public void insert(AuthorityDetailVO authorityDetailVO);

	public void update(AuthorityDetailVO authorityDetailVO);

	public void delete(AuthorityDetailVO authorityDetailVO);
	
	public List<ManagerAuthorityVO> findByManagerNo(Integer managerNo);

	public List<AuthorityDetailVO> getAll();

}
