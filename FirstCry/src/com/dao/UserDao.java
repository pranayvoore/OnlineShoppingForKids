package com.dao;

import java.sql.*;

import com.bean.User;

public class UserDao {
	public static boolean register(User u) throws SQLException, ClassNotFoundException {
		Connection c = ConnectionUtility.getConnection();
		PreparedStatement ps = c
				.prepareStatement("insert into user(name,email,password) values(?,?,aes_encrypt(?,'k1'))");
		ps.setString(1, u.getName());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getPassword());
		int res = ps.executeUpdate();
		if (res > 0) {
			return true;
		} else
			return false;
	}

	public static boolean checkEmailExists(String email) throws ClassNotFoundException, SQLException {
		Connection c = ConnectionUtility.getConnection();
		PreparedStatement ps = c.prepareStatement("select * from user where email=?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;
	}
	public static String getPwdWithEmail(String email) throws ClassNotFoundException, SQLException{
		Connection c = ConnectionUtility.getConnection();
		PreparedStatement ps = c.prepareStatement("select aes_decrypt(password,'k1') from user where email=?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			
		return rs.getString(1);
		}
		return "";
	}
	public static String UserName(String email) throws ClassNotFoundException, SQLException {
		Connection c =ConnectionUtility.getConnection();
			
			PreparedStatement ps = c.prepareStatement("select name from user where email =?");
			ps.setString(1,email);
			
			ResultSet rs =ps.executeQuery();
			rs.next();
			
				return rs.getString(1);
			
							
		}
	public static int UserID(String email) throws ClassNotFoundException, SQLException {
		Connection c =ConnectionUtility.getConnection();
			
			PreparedStatement ps = c.prepareStatement("select userid from user where email =?");
			ps.setString(1,email);
			
			ResultSet rs =ps.executeQuery();
			rs.next();
			
				return rs.getInt(1);
			
							
		}
}
