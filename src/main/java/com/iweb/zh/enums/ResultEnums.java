package com.iweb.zh.enums;

public enum ResultEnums {
	USERNAME_OCCUPIED("0001", "This userName is occupied."), //用户名被占用
	USER_UNACTIVATION("0002", "Please go to the mailbox to activate users."), //未激活
	USER_ACTIVATION("0003", "Success activate users."), //成功激活用户
	UNERROR("9999", "Unknown error occurred."), // 发生未知错误
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
