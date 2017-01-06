package com.soft.service;

import java.util.List;

import com.soft.dao.UserAddrDao;
import com.soft.domain.UserAddr;

public class UserAddrService {

	private UserAddrDao userAddrDao;
	
	public UserAddrService(){
		userAddrDao = new UserAddrDao();
	}
	
	public List<UserAddr> findAll(){
		String sql = " select * from tb_useraddr ";
		return userAddrDao.findBySql(sql);
	}
	
	public void delete(UserAddr userAddr){
		userAddrDao.delete(userAddr);
	}
	
	public void add(UserAddr userAddr){
		userAddrDao.add(userAddr);
	}
	
}
