package com.iweb.zh.entity;



public class User {
	
	private String uId;
	private String userName;
	private String passWord;
	
	public User(){};
	public User(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	
	
}
