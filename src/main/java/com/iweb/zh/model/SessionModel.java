package com.iweb.zh.model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * 用来记录session 
 * @author ZhangHeng
 *
 */
public class SessionModel {
	
	private static Map<String, HttpSession> allSession = new HashMap<String, HttpSession>();
	
	private static SessionModel sessionModel = null;
	
	private SessionModel() {
		if (null != sessionModel) {
			throw new RuntimeException();
		}
	}
	
	public static synchronized SessionModel getSessionModel() {
		if (null == sessionModel) 
			sessionModel = new SessionModel();
		return sessionModel;
	}
	
	/**
	 * 保存session
	 * @param sessionId
	 * @param session
	 */
	public void setSession(String sessionId, HttpSession session) {
		allSession.put(sessionId, session);
	}
	
	/**
	 * 根据 sessionId 获取session
	 * @param sessionId
	 * @return
	 */
	public HttpSession getSession(String sessionId) {
		return allSession.get(sessionId);
	}
	
	/**
	 * 根据 session 销毁 session
	 * @param sessionId
	 */
	public void distroySession(String sessionId) {
		HttpSession session = allSession.get(sessionId);
		allSession.remove(sessionId);
		session.invalidate();
	}
	
	
	/**
	 * 返回保存 session 的个数
	 * @return
	 */
	public int getLoginNum() {
		return allSession.size();
	}
	
}
