package com.iweb.zh.model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TimerModel {
	
	private boolean interval = false; //是否是间隔运行
	private long intervalNo = 1L; // 间隔运行的次数
	private long intervalTime = 20L; // 间隔时间 ms
	private Class<?> cls;

	public Class<?> getCls() {
		return cls;
	}

	public void setCls(Class<?> cls) {
		this.cls = cls;
	}

	public void setInterval() {
		this.interval = true;
		this.runTime.add(this.intervalTime);
		this.intervalNo--;
	}

	public long getIntervalNo() {
		return intervalNo;
	}

	public void setIntervalNo(long intervalNo) {
		this.intervalNo = intervalNo;
	}

	public long getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(long intervalTime) {
		this.intervalTime = intervalTime;
	}
	private Method method;
	private Object param;
	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}
	private List<Long> runTime = new ArrayList<Long>();
	private long time;
	
	
	
	public boolean isNotify() {
		if (null == this.runTime || this.runTime.size() == 0)
			return true;
		return false;
	}
	
	
	
	
	
	
	
	
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public List<Long> getRunTime() {
		return runTime;
	}
	public void setRunTime(List<Long> runTime) {
		this.runTime = runTime;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
	
	public boolean isRun(long time) {
		if (isNotify())
			return !isNotify();
		
		// 处理间隔运行
		if (interval && runTime.size() <= 1 && intervalNo > 0) {
			runTime.add(intervalTime);
			intervalNo--;
		}
		if (runTime.get(0) <= 0) {
			runTime.remove(0);
			return true;
		}
		
		runTime.set(0, runTime.get(0) - time);
		return false;
	}
	
	
	
	
	
}
