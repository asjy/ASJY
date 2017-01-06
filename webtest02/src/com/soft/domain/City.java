package com.soft.domain;

import java.util.Date;

public class City {
 
    private int id;

    private int pid;

    private String cityname;
    
    public City(){
    	
    }


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getPid() {
		return pid;
	}



	public void setPid(int pid) {
		this.pid = pid;
	}



	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

  
}