package com.iweb.zh.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iweb.zh.custormannotation.UnInterception;
import com.iweb.zh.entity.Power;
import com.iweb.zh.entity.User;
import com.iweb.zh.model.JsonResult;
import com.iweb.zh.service.UserService;


@Controller
@RequestMapping("/user")
@SuppressWarnings({"rawtypes", "unused"})
public class UserController {
	
	
	private final static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private UserService userService;
	
	/**
	 * 登陆
	 * 用户密码进行md5 加密 32位大写
	 * @return
	 */
	@UnInterception
	@PostMapping(value  = "/login")
	public String login(HttpServletRequest request, HttpServletResponse response,User user) {
		if (!userService.login(user)) {
			return "login";
		}
		List<Power> power = userService.getPowerByUserName(user.getUserName());
		HttpSession session = request.getSession();
		session.setAttribute("power", power);
		return "index";
	}
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@ResponseBody
	@UnInterception
	@PostMapping(path = "/signUp")
	public JsonResult signUp(User user) { 
		return userService.signUp(user);
	}
	
	/**
	 * 激活
	 * @param code
	 * @return
	 */
	@UnInterception
	@ResponseBody
	@RequestMapping("/activation/{code}")
	public JsonResult activation(@PathVariable(value = "code") String code) {
		return userService.activation(code);
	}
}
