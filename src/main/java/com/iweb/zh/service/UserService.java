package com.iweb.zh.service;

import java.util.List;

import com.iweb.zh.entity.Power;
import com.iweb.zh.entity.User;
import com.iweb.zh.model.JsonResult;

public interface UserService {
	
	/**
	 * 用户登陆
	 * @param u
	 * @return true 登陆成功 
	 */
	public boolean login(User u);

	/**
	 * 根据用户名查找用户的所有权限
	 * @param userName
	 * @return 用户的所有权限
	 */
	public List<Power> getPowerByUserName(String userName);

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public JsonResult signUp(User user);
	
}
