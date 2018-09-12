package com.iweb.zh.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iweb.zh.custormannotation.UnInterception;
import com.iweb.zh.model.TimerModel;
import com.iweb.zh.utils.TimerUtils;

@RestController
@RequestMapping("/testTimer")
public class TestTimerController {
	
	private static final Logger log = LoggerFactory.getLogger(TestTimerController.class);
	
	@UnInterception
	@RequestMapping("/test1")
	public String test1() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		
		TimerUtils timer = TimerUtils.getTimer();
		TimerModel model = new TimerModel();
		model.setIntervalNo(3); // 运行次数
		model.setIntervalTime(2000); // 间隔时间
		model.setInterval(); // 间隔运行
		
		model.setCls(Class.forName("com.iweb.zh.controller.TestTimerController"));
		model.setMethod(model.getCls().getMethod("aa", Object.class)); 
		model.setParam("this is test1 Interval timer");
		
		timer.addTimer(model);
		return "test1";
	}
	
	@UnInterception
	@RequestMapping("/test2")
	public String test2() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		
		TimerUtils timer = TimerUtils.getTimer();
		TimerModel model = new TimerModel();
		
		List<Long> l = new ArrayList<Long>();
		l.add(2000L);
		l.add(3000L);
		l.add(1000L);
		model.setRunTime(l);  
		
		
		model.setCls(Class.forName("com.iweb.zh.controller.TestTimerController"));
		model.setMethod(model.getCls().getMethod("aa", Object.class)); 
		model.setParam("this is test2 timer");
		
		timer.addTimer(model);
		return "test2";
	}
	
	
	public void aa(Object str) {
		log.info(str.toString());
	}
	
}
