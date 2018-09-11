package com.iweb.zh.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iweb.zh.custormannotation.UnInterception;
import com.iweb.zh.entity.User;
import com.iweb.zh.event.JavaMailEvent;
import com.iweb.zh.model.JavaMailModel;
import com.iweb.zh.service.UserService;
import com.iweb.zh.utils.JavaMailUtil;


@RestController
@RequestMapping("/test")
public class TestController {
	
	private final static Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Resource
	private UserService userService;
	
	@Resource
	JavaMailModel javaMailModel;
	
	@Resource
	private ApplicationContext applicationContext;
	
	@UnInterception
	@RequestMapping("/User")
	public User test() {
		log.info("this is test info");
		log.error("this is test error");
		log.debug("this is test debug");
		return new User("name", "pw"); 
	}
	
	@RequestMapping("/login")
	public void login() {
		boolean flag = userService.login(new User("zhangheng", "123456"));
		if (flag)
			log.info("登陆成功");
		
	}
	
	@RequestMapping("/mail")
	public void mail() throws UnsupportedEncodingException, MessagingException {
		
		
		
		javaMailModel.setReceiveAddress("1056948880@qq.com");
		javaMailModel.setReceiveName("this is receiveName");
		javaMailModel.setContent("this is content");
		javaMailModel.setSubject("this is subJect");
		JavaMailEvent event = new JavaMailEvent(this, javaMailModel);
		applicationContext.publishEvent(event); // 触发监听
		
	}
	
	@RequestMapping("/mail1")
	public void mail1() throws UnsupportedEncodingException, MessagingException {
		
//		javaMailModel.setReceiveAddress("1056948880@qq.com");
//		javaMailModel.setReceiveName("this is receiveName");
//		javaMailModel.setContent("this is content");
//		javaMailModel.setSubject("this is subJect");
		
		JavaMailUtil.sendMail(javaMailModel);
	}
	
}
