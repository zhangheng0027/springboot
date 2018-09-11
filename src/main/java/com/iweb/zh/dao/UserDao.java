package com.iweb.zh.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

	
	@Select("select passWord from `user` where userName = #{userName}")
	public String getPwByUserName(String userName);
	
}
