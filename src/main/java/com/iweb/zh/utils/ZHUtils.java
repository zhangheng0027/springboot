package com.iweb.zh.utils;

public class ZHUtils {
	
	private final static String str = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWXxyYzZ1234567890";
	
	/**
	 * 生成 len 长度的随机字符串
	 * @param len
	 * @return
	 */
	public static String getRandomStr(int len) {
		StringBuffer sb = new StringBuffer();
		final int strLen = str.length();
		for (int i = 0; i < len; i++)
			sb.append(str.charAt((int)Math.random() * strLen));
		return sb.toString();
	}
	
	
}
