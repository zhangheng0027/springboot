package com.iweb.zh.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.iweb.zh.model.JavaMailModel;

public class JavaMailUtil {

	public static void sendMail(JavaMailModel javaMailModel) throws 
	UnsupportedEncodingException, MessagingException {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", javaMailModel.getProtocol()); // 使用 smtp 想协议
		props.setProperty("mail.smtp.host", javaMailModel.getHost()); // 需要百度查对应邮箱对应地址协议的地址
		props.setProperty("mail.smtp.port", javaMailModel.getPort()); // 对应的端口
		props.setProperty("mail.smtp.auth", javaMailModel.getAuth()); // 需要授权
		
		// 配置 ssl 安全认证
		props.setProperty("mail.smtp.socketFactory.class", javaMailModel.getSocketfactoryclass());
		props.setProperty("mail.smtp.socketFactory.fallback", javaMailModel.getSocketfactoryfallback());
		props.setProperty("mail.smtp.socketFactory.port", javaMailModel.getSocketfactoryport());
		
		Session session = Session.getInstance(props);
		session.setDebug(true);
		
		MimeMessage message = new MimeMessage(session);
		Address address = new InternetAddress(javaMailModel.getSendaddress(), javaMailModel.getSendname(), "UTF-8");
		
		message.setFrom(address);
		message.setSubject(javaMailModel.getSubject(), "UTF-8"); // 标题
		message.setContent(javaMailModel.getContent(), "text/html;charset=UTF-8"); // 内容
		
		
		// 收件人类型： TO 普通收件人， CC抄送， BCC密送
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(javaMailModel.getReceiveAddress(), javaMailModel.getReceiveName(), "UTF-8"));
		
		message.setSentDate(new Date());
		message.saveChanges();
		
		Transport transport = session.getTransport();
		transport.connect(javaMailModel.getAccount(), javaMailModel.getPassword()); // 邮箱账号，密码
		// 清除收件人信息
		javaMailModel.clear();
		transport.sendMessage(message, message.getAllRecipients()); // 发送邮件
	}
	
}
