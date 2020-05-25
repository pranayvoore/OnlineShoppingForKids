package com.bean;

public class Product {
	private int productid;
	private String name;
	private int price;
	private String image;
	private String category;
	public Product() {
		super();
	}
	public Product(String name, int price, String image, String category) {
		super();
		this.name = name;
		this.price = price;
		this.image = image;
		this.category = category;
	}
	public Product(int id, String name, int price, String image, String category) {
		super();
		this.productid = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.category = category;
	}
	public int getId() {
		return productid;
	}
	public void setId(int id) {
		this.productid = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
