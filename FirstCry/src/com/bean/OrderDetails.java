package com.bean;

public class OrderDetails {
private int orderdetailsid;
private Orders orderid;
private Product productid;
private int quantity;
public OrderDetails() {
	super();
}
public OrderDetails(Orders orderid, Product productid, int quantity) {
	super();
	this.orderid = orderid;
	this.productid = productid;
	this.quantity = quantity;
}
public OrderDetails(int orderdetailsid, Orders orderid, Product productid, int quantity) {
	super();
	this.orderdetailsid = orderdetailsid;
	this.orderid = orderid;
	this.productid = productid;
	this.quantity = quantity;
}
public int getOrderdetailsid() {
	return orderdetailsid;
}
public void setOrderdetailsid(int orderdetailsid) {
	this.orderdetailsid = orderdetailsid;
}
public Orders getOrderid() {
	return orderid;
}
public void setOrderid(Orders orderid) {
	this.orderid = orderid;
}
public Product getProductid() {
	return productid;
}
public void setProductid(Product productid) {
	this.productid = productid;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}
