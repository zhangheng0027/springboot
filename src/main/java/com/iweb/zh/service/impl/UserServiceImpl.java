package com.iweb.zh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iweb.zh.dao.UserDao;
import com.iweb.zh.entity.Power;
import com.iweb.zh.entity.User;
import com.iweb.zh.model.JsonResult;
import com.iweb.zh.service.UserService;
import com.iweb.zh.utils.Md5Util;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Override
	public boolean login(User u) {
		if (null == u || Strings.isEmpty(u.getUserName()) || Strings.isEmpty(u.getPassWord()))
			return false;
		String pw = userDao.getPwByUserName(u.getUserName());
		if (u.getPassWord().equals(pw))
			return true;
		return false;
	}

	@Override
	public List<Power> getPowerByUserName(String userName) {
		return userDao.getPowerByUserName(userName);
	}

	@Override
	public JsonResult signUp(User user) {
		
		
		
		return null;
	}
	

}
