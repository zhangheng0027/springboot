package com.iweb.zh.model;

import com.iweb.zh.enums.ResultEnums;

public class  JsonResult<T> {
	
	private String code;
	private String msg;
	private T data;
	
	
	public JsonResult(ResultEnums enums) {
		this.code = enums.getCode();
		this.msg = enums.getMsg();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public JsonResult() {
		super();
		this.code = "200";
        this.msg = "操作成功";
	}
	public JsonResult(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "JsonResult [code=" + code + ", msg=" + msg + "]";
	}
	
	
	
}
