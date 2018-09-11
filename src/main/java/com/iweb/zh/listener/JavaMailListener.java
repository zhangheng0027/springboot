package com.iweb.zh.listener;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

import com.iweb.zh.event.JavaMailEvent;
import com.iweb.zh.model.JavaMailModel;
import com.iweb.zh.utils.JavaMailUtil;

public class JavaMailListener implements ApplicationListener<JavaMailEvent> {

	private final static Logger log = LoggerFactory.getLogger(JavaMailListener.class);
	@Override
	public void onApplicationEvent(JavaMailEvent event) {
		JavaMailModel javaMailModel = event.getJavaMailModel();
		try {
			JavaMailUtil.sendMail(javaMailModel);
		} catch (UnsupportedEncodingException | MessagingException e) {
			log.error("JavaMailListener 发送邮件失败");
		}
	}
	

}
