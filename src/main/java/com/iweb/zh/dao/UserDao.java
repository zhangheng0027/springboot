package com.iweb.zh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.iweb.zh.entity.Power;
import com.iweb.zh.entity.User;

@Repository
public interface UserDao {

	/**
	 * 根据用户名获取密码
	 * @param userName
	 * @return
	 */
	@Select("select passWord from `user` where userName = #{userName} and start = '0'")
	public String getPwByUserName(String userName);
	
	/**
	 * 根据用户名获取用户的所有权限
	 * @param userName
	 * @return
	 */
	public List<Power> getPowerByUserName(String userName);

	/**
	 * 判断用户名是否被占用
	 * @param userName
	 * @return
	 */
	@Select("select count(1) from `user` where userName = #{userName}")
	public int hasUserName(String userName);

	/**
	 * 用户注册 状态为  未激活
	 * @param user
	 */
	@Insert("insert int `user`(userName, passWord, start, email) values(#{userName}, #{passWord}, '1', #{email})")
	public void signUp(User user);
	
}
