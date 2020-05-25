package com.dao;

import java.sql.*;

public class OrdersDao {
	public static boolean Generatebill(int custId,int ta,Timestamp t) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into orders(userid,totalamount,order_date)values(?,?,?)");
			ps.setInt(1, custId);
			ps.setInt(2,ta);
			ps.setTimestamp(3,t);
			
			
			int val = ps.executeUpdate();
			if (val > 0) {
				return true;
			} else

				return false;

		}
	public static int GetOrderIDwithUserId(int custId) throws ClassNotFoundException, SQLException {
		Connection c =ConnectionUtility.getConnection();
			
			PreparedStatement ps = c.prepareStatement("select ordersid from orders where userid =?");
			ps.setInt(1,custId);
			
			ResultSet rs =ps.executeQuery();
			rs.next();
				return rs.getInt(1);
			
							
		}
}
