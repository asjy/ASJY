package com.soft.service;

import java.util.List;

import com.soft.dao.UserDao;
import com.soft.domain.User;

public class UserService {

	private UserDao userDao;
	
	public UserService(){
		userDao = new UserDao();
	}
	
	public List<User> findAll(){
		String sql = " select * from tb_user ";
		return userDao.findBySql(sql);
	}
	
	public User findById(String id){
		String sql = " select * from tb_user where id="+id+"";
		List<User>list_user = userDao.findBySql(sql);
		if(list_user!=null && list_user.size()==1){
			return list_user.get(0);
		}
		return null;
	}
	
	public void delete(User user){
		userDao.delete(user);
	}
	
	public void add(User user){
		userDao.add(user);
	}
	
	public void update(User user){
		userDao.update(user);
	}
	
	public User findByName(String username){
		
		String sql = " select * from tb_user where username='"+username+"'";
		
		List<User> list = userDao.findBySql(sql);
		if(list!=null && list.size()==1){
			return list.get(0);
		}
		return null;
	}
	
}
