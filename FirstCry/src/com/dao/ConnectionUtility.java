package com.dao;

import java.sql.*;
public class ConnectionUtility {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/firstcry","root","root");
	}
}
