package com.bean;

import java.sql.Timestamp;

public class Orders {
private int orderid;
private int totalamount;
private User userid;
private Timestamp orderdate;
public Orders() {
	super();
}
public Orders(int totalamount, User userid, Timestamp orderdate) {
	super();
	this.totalamount = totalamount;
	this.userid = userid;
	this.orderdate = orderdate;
}
public Orders(int orderid, int totalamount, User userid, Timestamp orderdate) {
	super();
	this.orderid = orderid;
	this.totalamount = totalamount;
	this.userid = userid;
	this.orderdate = orderdate;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getTotalamount() {
	return totalamount;
}
public void setTotalamount(int totalamount) {
	this.totalamount = totalamount;
}
public User getUserid() {
	return userid;
}
public void setUserid(User userid) {
	this.userid = userid;
}
public Timestamp getOrderdate() {
	return orderdate;
}
public void setOrderdate(Timestamp orderdate) {
	this.orderdate = orderdate;
}

}
