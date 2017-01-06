package com.soft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soft.domain.City;

public class CityDao {

	//四大方法
	public void add(City city){
		Connection co = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String str = "jdbc:mysql://127.0.0.1:3306/webtest";
			String str1 = "root";
			String str2 = "root";

			co = DriverManager.getConnection(str, str1 , str2);
			
			String sql = " insert into tb_city (cityname, pid) values (?,?)";
			ps = co.prepareStatement(sql);
			
			ps.setString(1, city.getCityname());
			ps.setInt(2, city.getPid());
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				ps.close();
				co.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void update(City city){
		
	}
	public void delete(City city){
		Connection co = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String str = "jdbc:mysql://127.0.0.1:3306/webtest";
			String str1 = "root";
			String str2 = "root";

			co = DriverManager.getConnection(str, str1 , str2);
			
			String sql = " delete from tb_city where id=?";
			ps = co.prepareStatement(sql);
			ps.setInt(1, city.getId());
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				ps.close();
				co.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public List<City> findBySql(String sql){
		
		Connection co = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<City> list_city = new ArrayList<City>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String str = "jdbc:mysql://127.0.0.1:3306/webtest";
			String str1 = "root";
			String str2 = "root";

			co = DriverManager.getConnection(str, str1 , str2);
			
			ps = co.prepareStatement(sql);

			rs = ps.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String cityname = rs.getString("cityname");
				int pid = rs.getInt("pid");
				
				City city = new City();
				city.setId(id);
				city.setCityname(cityname);
				city.setPid(pid);
				list_city.add(city);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				ps.close();
				co.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return list_city;
	}

}
