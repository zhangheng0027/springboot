package com.iweb.zh.utils;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;


import com.iweb.zh.model.TimerModel;

public class TimerUtils implements Serializable, Runnable {
	
	private static final long serialVersionUID = -6806764620652924283L;
	
	
	private final static long minSleep = 20L;
	
	private static Set<TimerModel> set = new HashSet<TimerModel>();
	
	
	private static TimerUtils timer;
	
	
	private TimerUtils() {
		// 防止反射
		if (null != timer)
			throw new RuntimeException();
	}
	
	
	public static synchronized TimerUtils getTimer() {
		if (null == timer)
			timer = new TimerUtils();
		return timer;
	}
	
	private Object readResolve() throws ObjectStreamException  {
		return timer;
	}
	
	public void addTimer(TimerModel timerModel) {
		set.add(timerModel);
	}


	@Override
	public void run() {
		while (true) {
			try {
				
				for (TimerModel model : set) {
					if (model.isNotify()) {
						set.remove(model);
						continue;
					}
					if (model.isRun(minSleep)) {
						Method method = model.getMethod();
						method.invoke(model.getCls().newInstance(), model.getParam());
					}
				}
				
				Thread.sleep(minSleep);
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
	}
	
}
