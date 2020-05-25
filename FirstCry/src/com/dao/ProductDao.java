package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bean.Product;

public class ProductDao {
	public static List<String> getAllCategories() throws ClassNotFoundException, SQLException {
		Connection c = ConnectionUtility.getConnection();
		PreparedStatement ps = c.prepareStatement("select distinct category from product");
		ResultSet rs = ps.executeQuery();
		List<String> cList = new ArrayList<String>();
		while (rs.next()) {
			cList.add(rs.getString(1));
		}
		return cList;
	}
	public static ArrayList<Product> GetAllProductDetails() throws ClassNotFoundException, SQLException {

		Connection con = ConnectionUtility.getConnection();

		PreparedStatement ps = con.prepareStatement("select * from product");

		ResultSet val = ps.executeQuery();
		ArrayList<Product>elist=new ArrayList<>();
		Product p = null;
		while (val.next()) {
		p= new Product();
		p.setId(val.getInt(1));
		p.setName(val.getString(2));
		p.setPrice(val.getInt(3));
		p.setImage(val.getString(4));
		p.setCategory(val.getString(5));
		elist.add(p);
		}
		return elist;
		}
	public static ArrayList<Product> GetAllProductDetailsWithCategory(String Category) throws ClassNotFoundException, SQLException {

		Connection con = ConnectionUtility.getConnection();

		PreparedStatement ps = con.prepareStatement("select * from product where category=?");
		ps.setString(1, Category);
		ResultSet val = ps.executeQuery();
		ArrayList<Product>elist=new ArrayList<>();
		Product p = null;
		while (val.next()) {
		p= new Product();
		p.setId(val.getInt(1));
		p.setName(val.getString(2));
		p.setPrice(val.getInt(3));
		p.setImage(val.getString(4));
		p.setCategory(val.getString(5));
		elist.add(p);
		}
		return elist;
		}
	public static Product GetAllProductsWithID(int id) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from product where productid=?");
		ps.setInt(1, id); 
		ResultSet val = ps.executeQuery();
		Product p = null;
		while (val.next()) {
			p= new Product(val.getInt(1),val.getString(2),val.getInt(3),val.getString(4),val.getString(5));
				
		}
		return p;
		
	}
}
