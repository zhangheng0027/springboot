package com.iweb.zh.enums;

public enum ResultEnums {
	USERNAME_OCCUPIED("0001", "This userName is occupied."), //用户名被占用
	USER_UNACTIVATION("0002", "Please go to the mailbox to activate users.") //未激活
	;
	
	public String getCode() {
		return Code;
	}

	public String getMsg() {
		return Msg;
	}

	private String Code;
	private String Msg;
	
	ResultEnums(String code, String msg) {
		this.Code = code;
		this.Msg = msg;
	}
}
