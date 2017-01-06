package com.soft.service;

import java.util.List;

import com.soft.dao.CityDao;
import com.soft.domain.City;

public class CityService {

	private CityDao cityDao;
	
	public CityService(){
		cityDao = new CityDao();
	}
	/**
	 * 查询所有省
	 * @return
	 */
	public List<City> findProvince(){
		String sql = " select * from tb_city where pid is null ";
		return cityDao.findBySql(sql);
	}
	/**
	 * 根据pid查询市或区
	 * @param pid
	 * @return
	 */
	public List<City> findCity(String pid){
		String sql = " select * from tb_city where pid ='"+pid+"' ";
		return cityDao.findBySql(sql);
	}
	
	/**
	 * 
	 */
	public City findByName(String name){
		String sql = " select * from tb_city where cityname ='"+name+"' ";
		List<City> list_city = cityDao.findBySql(sql);
		if(list_city != null && list_city.size() == 1){
			return list_city.get(0);
		}
		return null;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public City findById(String id){
		String sql = " select * from tb_city where id ='"+id+"' ";
		List<City> list_city = cityDao.findBySql(sql);
		if(list_city != null && list_city.size() == 1){
			return list_city.get(0);
		}
		return null;
	}
	
	public City findByAllId(String pid, String cid, String did){
		String sql = " SELECT c1.id, CONCAT( c1.cityname, ' ',c2.cityname,' ', c3.cityname ) AS cityname, c1.pid FROM tb_city c1, tb_city c2, tb_city c3 WHERE c1.id = c2.pid AND c2.id = c3.pid AND c1.id = '"+pid+"' AND c2.id = '"+cid+"' AND c3.id = '"+did+"' ";
		List<City> list_city = cityDao.findBySql(sql);
		if(list_city != null && list_city.size() == 1){
			return list_city.get(0);
		}
		return null;
	}
}
