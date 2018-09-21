package com.iweb.zh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.iweb.zh.entity.Power;

@Repository
public interface UserDao {

	
	@Select("select passWord from `user` where userName = #{userName}")
	public String getPwByUserName(String userName);
	
	
	public List<Power> getPowerByUserName(String userName);
	
}
