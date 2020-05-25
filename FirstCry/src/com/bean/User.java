package com.bean;

public class User {
private int userid;
private String name;
private String email;
private String password;
public User() {
	super();
}
public User(String name, String email, String password) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
}
public User(int id, String name, String email, String password) {
	super();
	this.userid = id;
	this.name = name;
	this.email = email;
	this.password = password;
}
public int getId() {
	return userid;
}
public void setId(int id) {
	this.userid = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
