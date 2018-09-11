package com.iweb.zh.service.impl;

import javax.annotation.Resource;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iweb.zh.dao.UserDao;
import com.iweb.zh.entity.User;
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
		if (Md5Util.MD5Encode(u.getPassWord(), "UTF8", true).equals(pw))
			return true;
		return false;
	}
	

}
