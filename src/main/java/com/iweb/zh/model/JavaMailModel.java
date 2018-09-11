package com.iweb.zh.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "javamail")
public class JavaMailModel {
	
	@Value("${javamail.sendaddress}")
	private String sendaddress;
	@Value("${javamail.sendname}")
	private String sendname;
	@Value("${javamail.account}")
	private String account;
	@Value("${javamail.password}")
	private String password;
	@Value("${javamail.protocol}")
	private String protocol;
	@Value("${javamail.host}")
	private String host;
	@Value("${javamail.port}")
	private String port;
	@Value("${javamail.auth}")
	private String auth;
	@Value("${javamail.socketfactoryclass}")
	private String socketfactoryclass;
	@Value("${javamail.socketfactoryfallback}")
	private String socketfactoryfallback;
	@Value("${javamail.socketfactoryport}")
	private String socketfactoryport;
	
	private String receiveAddress;
	private String receiveName;
	private String subject;
	private String content;
	
	
	public JavaMailModel() {}
	
	public void clear() {
		this.receiveAddress = null;
		this.receiveName = null;
		this.subject = null;
		this.content = null;
	}
	
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getSendaddress() {
		return sendaddress;
	}
	public void setSendaddress(String sendaddress) {
		this.sendaddress = sendaddress;
	}
	public String getSendname() {
		return sendname;
	}
	public void setSendname(String sendname) {
		this.sendname = sendname;
	}
	public String getSocketfactoryclass() {
		return socketfactoryclass;
	}
	public void setSocketfactoryclass(String socketfactoryclass) {
		this.socketfactoryclass = socketfactoryclass;
	}
	public String getSocketfactoryfallback() {
		return socketfactoryfallback;
	}
	public void setSocketfactoryfallback(String socketfactoryfallback) {
		this.socketfactoryfallback = socketfactoryfallback;
	}
	public String getSocketfactoryport() {
		return socketfactoryport;
	}
	public void setSocketfactoryport(String socketfactoryport) {
		this.socketfactoryport = socketfactoryport;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReceiveAddress() {
		return receiveAddress;
	}
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
}
