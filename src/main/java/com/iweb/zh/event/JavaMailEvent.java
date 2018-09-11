package com.iweb.zh.event;

import org.springframework.context.ApplicationEvent;

import com.iweb.zh.model.JavaMailModel;

@SuppressWarnings("serial")
public class JavaMailEvent extends ApplicationEvent{
	private JavaMailModel javaMailModel;
	
	public JavaMailModel getJavaMailModel() {
		return javaMailModel;
	}

	public void setJavaMailModel(JavaMailModel javaMailModel) {
		this.javaMailModel = javaMailModel;
	}

	public JavaMailEvent(Object source, JavaMailModel javaMailModel) {
		super(source);
		this.javaMailModel = javaMailModel;
	};
}
