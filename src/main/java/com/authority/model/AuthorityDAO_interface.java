package com.authority.model;

import java.util.List;


public interface AuthorityDAO_interface {
	public void insert(AuthorityVO authorityVO);
	public void update(AuthorityVO authorityVO);
	public void delete(AuthorityVO authorityVO);
	public AuthorityVO findByPrimaryKey(Integer authorityNo);
	public List<AuthorityVO> getAll();
	
	

}
