package com.iweb.zh.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.iweb.zh.utils.TimerUtils;

/**
 * 启动定时器
 * @author ZhangHeng
 *
 */
@SuppressWarnings("rawtypes")
public class qidong implements ApplicationContextInitializer {
	private final static Logger log = LoggerFactory.getLogger(qidong.class);
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		log.info(">>>>>>>>>>>>>>>> start TimerUtils class <<<<<<<<<<<<<<<<");
		
		TimerUtils timer = TimerUtils.getTimer();
		Thread thread = new Thread(timer);
		thread.start();
		
		log.info(">>>>>>>>>>>>>>>> start TimerUtils class success <<<<<<<<<<<<<<<<");
		
	}

}
