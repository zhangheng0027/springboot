package com.iweb.zh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iweb.zh.dao.UserDao;
import com.iweb.zh.entity.Power;
import com.iweb.zh.entity.User;
import com.iweb.zh.enums.ResultEnums;
import com.iweb.zh.event.JavaMailEvent;
import com.iweb.zh.model.JavaMailModel;
import com.iweb.zh.model.JsonResult;
import com.iweb.zh.service.UserService;
import com.iweb.zh.utils.Md5Util;
import com.iweb.zh.utils.ZHUtils;
import com.zaxxer.hikari.util.ClockSource.Factory;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

	private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource
	private UserDao userDao;
	
	@Resource
	JavaMailModel javaMailModel;
	
	@Resource
	private ApplicationContext applicationContext;
	
	@Resource
	private Environment env;
	
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

	@SuppressWarnings("rawtypes")
	@Override
	public JsonResult signUp(User user) {
		JsonResult result = null;
		if (userDao.hasUserName(user.getUserName()) > 0) {
			result = new JsonResult(ResultEnums.USERNAME_OCCUPIED);
		} else {
			String code = ZHUtils.getRandomStr(50);
			user.setActionCode(code);
			userDao.signUp(user);
			StringBuffer sb = new StringBuffer();
			sb.append(env.getProperty("url"));
			sb.append("/user/activation/").append(code);
			javaMailModel.setReceiveAddress(user.getEmail());
			javaMailModel.setReceiveName(user.getUserName());
			javaMailModel.setContent("Activation");
			javaMailModel.setSubject(sb.toString());
			JavaMailEvent event = new JavaMailEvent(this, javaMailModel);
			applicationContext.publishEvent(event); // 触发监听
			result = new JsonResult(ResultEnums.USER_UNACTIVATION);
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public JsonResult activation(String code) {
		JsonResult result = null;
		try {
			userDao.activation(code);
		} catch (Exception e) {
			
		}
		
		return result;
	}
	

}
