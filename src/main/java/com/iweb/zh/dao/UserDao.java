package com.iweb.zh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
	 * 用户注册 状态为  未激活v
	 * @param user
	 */
	@Insert("insert into `user`(userName, passWord, start, email, actionCode) values(#{userName}, #{passWord}, '1', #{email}, #{actionCode})")
	public void signUp(User user);

	/**
	 * 用户激活
	 * @param code
	 */
	@Update("update `user` set start = '0', actionTime = CURRENT_TIMESTAMP, actionCode = null where start = '1' and actionCode = #{code}")
	public void activation(String code);

	/**
	 * 根据code 获取用户id
	 * @param code
	 * @return
	 */
	@Select("select uId from `user` where actionCode = #{code}")
	public String getUserIdByCode(String code);
	
	@Insert("insert into `user_role`(userId, roleId) values(#{uId}, #{roleId})")
	public void changeUserRole(String uId, String roleId);
	
}
