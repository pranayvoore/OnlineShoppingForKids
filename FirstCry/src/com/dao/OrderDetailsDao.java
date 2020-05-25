package com.dao;

import java.sql.*;

public class OrderDetailsDao {
	public static boolean AddOrderDetails(int orderid,int pId, int quantity) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into order_details(ordersid,productid,quantity)values(?,?,?)");
			ps.setInt(1, orderid);
			ps.setInt(2,pId);
			ps.setInt(3,quantity);				
			int val = ps.executeUpdate();
			if (val > 0) {
				return true;
			} else

				return false;
	}
}
