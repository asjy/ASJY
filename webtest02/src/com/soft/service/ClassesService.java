package com.soft.service;

import java.util.List;

import com.soft.dao.ClassesDao;
import com.soft.domain.Classes;

public class ClassesService {

	private ClassesDao classesDao;
	
	public ClassesService(){
		classesDao = new ClassesDao();
	}
	
	public List<Classes> findAll(){
		String sql = " select * from tb_classes ";
		return classesDao.findBySql(sql);
	}
	
	
}
