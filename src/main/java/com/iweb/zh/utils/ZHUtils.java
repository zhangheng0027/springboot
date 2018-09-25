package com.iweb.zh.utils;

import java.util.Random;

public class ZHUtils {
	
	private final static String str = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWXxyYzZ1234567890";
	
	/**
	 * 生成 len 长度的随机字符串
	 * @param len
	 * @return
	 */
	public static String getRandomStr(int len) {
		StringBuffer sb = new StringBuffer();
		Random rand = new Random();
		final int strLen = str.length();
		for (int i = 0; i < len; i++)
			sb.append(str.charAt(rand.nextInt(strLen)));
		return sb.toString();
	}
	
	
}
