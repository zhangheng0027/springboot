package com.iweb.zh.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iweb.zh.custormannotation.UnInterception;
import com.iweb.zh.entity.Power;
import com.iweb.zh.entity.User;
import com.iweb.zh.model.JsonResult;
import com.iweb.zh.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	private final static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private UserService userService;
	
	/**
	 * 用户密码进行md5 加密 32位大写
	 * @return
	 */
	@RequestMapping("/login")
	@UnInterception
	public String login(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
		if (!userService.login(user)) {
			return "login";
		}
		List<Power> power = userService.getPowerByUserName(user.getUserName());
		HttpSession session = request.getSession();
		session.setAttribute("power", power);
		return "index";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/signUp")
	@ResponseBody
	@UnInterception
	public JsonResult signUp(@RequestBody User user) {
		
		JsonResult f = userService.signUp(user);
		
		return null;
	}
	
	
}
