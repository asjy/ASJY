package com.soft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soft.domain.User;

public class UserDao {

	//四大方法
	public void add(User user){
		Connection co = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String str = "jdbc:mysql://127.0.0.1:3306/webtest02";
			String str1 = "root";
			String str2 = "root";

			co = DriverManager.getConnection(str, str1 , str2);
			
			String sql = " insert into tb_user (username, password, addtime, classesid) values (?,?,now(),?)";
			ps = co.prepareStatement(sql);
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getClassesid());
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
	public void update(User user){
		Connection co = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String str = "jdbc:mysql://127.0.0.1:3306/webtest02";
			String str1 = "root";
			String str2 = "root";

			co = DriverManager.getConnection(str, str1 , str2);
			
			String sql = " update tb_user set username=?,password=?,classesid=? where id=?";
			ps = co.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getClassesid());
			ps.setInt(4, user.getId());
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
	public void delete(User user){
		Connection co = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String str = "jdbc:mysql://127.0.0.1:3306/webtest02";
			String str1 = "root";
			String str2 = "root";

			co = DriverManager.getConnection(str, str1 , str2);
			
			String sql = " delete from tb_user where id=?";
			ps = co.prepareStatement(sql);
			ps.setInt(1, user.getId());
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
	public List<User> findBySql(String sql){
		
		Connection co = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<User> list_user = new ArrayList<User>();
		
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
				String username = rs.getString("username");
				String password = rs.getString("password");
				String addtime = rs.getString("addtime");
				int classesid = rs.getInt("classesid");
				User user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
				user.setAddtime(addtime);
				user.setClassesid(classesid);
				list_user.add(user);
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
