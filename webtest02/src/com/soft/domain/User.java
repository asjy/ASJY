package com.soft.domain;

public class User {

	private int id;
	
	private String username;
	
	private String password;
	
	private String addtime;
	
	private int classesid;
	
	public User(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public int getClassesid() {
		return classesid;
	}

	public void setClassesid(int classesid) {
		this.classesid = classesid;
	}
	
	
	
}
