package com.soft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soft.domain.Classes;

public class ClassesDao {

	//四大方法
	public void add(Classes classes){
		Connection co = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String str = "jdbc:mysql://127.0.0.1:3306/webtest02";
			String str1 = "root";
			String str2 = "root";

			co = DriverManager.getConnection(str, str1 , str2);
			
			String sql = " insert into tb_classes (classesname) values (?)";
			ps = co.prepareStatement(sql);
			
			ps.setString(1, classes.getClassesname());
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
	public void update(Classes classes){
		Connection co = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String str = "jdbc:mysql://127.0.0.1:3306/webtest02";
			String str1 = "root";
			String str2 = "root";

			co = DriverManager.getConnection(str, str1 , str2);
			
			String sql = " update tb_classes set classesname=? where id=?";
			ps = co.prepareStatement(sql);
			ps.setString(1, classes.getClassesname());
			ps.setInt(2, classes.getId());
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
	public void delete(Classes classes){
		Connection co = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String str = "jdbc:mysql://127.0.0.1:3306/webtest02";
			String str1 = "root";
			String str2 = "root";

			co = DriverManager.getConnection(str, str1 , str2);
			
			String sql = " delete from tb_classes where id=?";
			ps = co.prepareStatement(sql);
			ps.setInt(1, classes.getId());
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
	public List<Classes> findBySql(String sql){
		
		Connection co = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Classes> list_user = new ArrayList<Classes>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String str = "jdbc:mysql://127.0.0.1:3306/webtest02";
			String str1 = "root";
			String str2 = "root";

			co = DriverManager.getConnection(str, str1 , str2);
			
			ps = co.prepareStatement(sql);

			rs = ps.executeQuery();
			
			while(rs.next()){
				
				int id = rs.getInt("id");
				String classesname = rs.getString("classesname");
				Classes classes = new Classes();
				classes.setId(id);
				classes.setClassesname(classesname);
				list_user.add(classes);
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
		return list_user;
	}

}
