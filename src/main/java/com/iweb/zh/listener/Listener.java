package com.iweb.zh.listener;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import com.iweb.zh.event.JavaMailEvent;
import com.iweb.zh.model.JavaMailModel;
import com.iweb.zh.utils.JavaMailUtil;

@SuppressWarnings("rawtypes")
@EnableAsync
@Component
public class Listener implements ApplicationListener {

	private final static Logger log = LoggerFactory.getLogger(Listener.class);
	
	

	@SuppressWarnings("unused")
	@Async
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof JavaMailEvent) {
			log.info("发送邮件");
			JavaMailEvent javaMailEvent = (JavaMailEvent)event;
			JavaMailModel javaMailModel = javaMailEvent.getJavaMailModel();
			try {
				JavaMailUtil.sendMail(javaMailModel);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

}
