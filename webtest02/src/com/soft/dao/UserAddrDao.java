package com.soft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soft.domain.UserAddr;

public class UserAddrDao {

	//四大方法
	public void add(UserAddr userAddr){
		Connection co = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String str = "jdbc:mysql://127.0.0.1:3306/webtest02";
			String str1 = "root";
			String str2 = "root";

			co = DriverManager.getConnection(str, str1 , str2);
			
			String sql = " insert into tb_useraddr (receiver, addr, receivertel, receiveraddr) values (?,?,?,?)";
			ps = co.prepareStatement(sql);
			
			ps.setString(1, userAddr.getReceiver());
			ps.setString(2, userAddr.getAddr());
			ps.setLong(3, userAddr.getReceivertel());
			ps.setString(4, userAddr.getReceiveraddr());
			
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
	public void update(UserAddr userAddr){
		Connection co = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String str = "jdbc:mysql://127.0.0.1:3306/webtest02";
			String str1 = "root";
			String str2 = "root";

			co = DriverManager.getConnection(str, str1 , str2);
			
			String sql = " update tb_useraddr set receiver=?, addr=?, receivertel=?, receiveraddr=? where id=?";
			ps = co.prepareStatement(sql);
			ps.setString(1, userAddr.getReceiver());
			ps.setString(2, userAddr.getAddr());
			ps.setLong(3, userAddr.getReceivertel());
			ps.setString(4, userAddr.getReceiveraddr());
			ps.setInt(5, userAddr.getId());
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
	public void delete(UserAddr userAddr){
		Connection co = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String str = "jdbc:mysql://127.0.0.1:3306/webtest02";
			String str1 = "root";
			String str2 = "root";

			co = DriverManager.getConnection(str, str1 , str2);
			
			String sql = " delete from tb_userAddr where id=?";
			ps = co.prepareStatement(sql);
			ps.setInt(1, userAddr.getId());
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
	public List<UserAddr> findBySql(String sql){
		
		Connection co = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<UserAddr> list_userAddr = new ArrayList<UserAddr>();
		
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
				String receiver = rs.getString("receiver");
				String addr = rs.getString("addr");
				Long receivertel = rs.getLong("receivertel");
				String receiveraddr = rs.getString("receiveraddr");
			
				UserAddr userAddr = new UserAddr();
				userAddr.setId(id);
				userAddr.setReceiver(receiver);
				userAddr.setAddr(addr);
				userAddr.setReceivertel(receivertel);
				userAddr.setReceiveraddr(receiveraddr);
				
				list_userAddr.add(userAddr);
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
		return list_userAddr;
	}

}
