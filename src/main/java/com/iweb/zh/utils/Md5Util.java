package com.iweb.zh.utils;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Md5Util {
	
	/** 16进制的字符数组 */
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	/**
	 * 
	 * 
	 * @param source
	 *            需要加密的原字符串
	 * @param encoding
	 *            指定编码类型
	 * @param uppercase
	 *            是否转为大写字符串
	 * @return
	 */
	public static String MD5Encode(String source, String encoding, boolean uppercase) {
		String result = null;
		try {
			result = source;
			// 获得MD5摘要对象
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			// 使用指定的字节数组更新摘要信息
			messageDigest.update(result.getBytes(encoding));
			// messageDigest.digest()获得16位长度
			result = byteArrayToHexString(messageDigest.digest());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return uppercase ? result.toUpperCase() : result;
	}

	/**
	 * 转换字节数组为16进制字符串
	 * 
	 * @param bytes
	 *            字节数组
	 * @return
	 */
	private static String byteArrayToHexString(byte[] bytes) {
		StringBuilder stringBuilder = new StringBuilder();
		for (byte tem : bytes) {
			stringBuilder.append(byteToHexString(tem));
		}
		return stringBuilder.toString();
	}

	/**
	 * 转换byte到16进制
	 * 
	 * @param b
	 *            要转换的byte
	 * @return 16进制对应的字符
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String getSign(Map<String, String> map) {

		String result = "";
		try {
			List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(map.entrySet());
			// 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
			Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {

				public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
					return (o1.getKey()).toString().compareTo(o2.getKey());
				}
			});

			// 构造签名键值对的格式
			StringBuilder sb = new StringBuilder();
			for (Map.Entry<String, String> item : infoIds) {
				if (item.getKey() != null || item.getKey() != "") {
					String key = item.getKey();
					String val = item.getValue();
					if (!(val == "" || val == null)) {
						sb.append(key + "=" + val + "&");
					}

				}

			}
			// sb.append(PropertyManager.getProperty("SIGNKEY"));
			result = sb.toString();
			result = result.substring(0, result.length() - 1);
			// 进行MD5加密
			// result = DigestUtils.md5Hex(result).toUpperCase();
		} catch (Exception e) {
			return null;
		}
		return result;
	}

	/**
	 * map转换成parm key=value形式
	 * 
	 * @param map
	 * @return
	 */
	public static String map2String(Map<Object, Object> map) {
		Iterator<Entry<Object, Object>> entries = map.entrySet().iterator();
		StringBuffer sb = new StringBuffer("");
		while (entries.hasNext()) {
			Entry<Object, Object> entry = entries.next();
			sb.append("&" + entry.getKey() + "=" + entry.getValue());
		}
		String str = "";
		str = sb.substring(1, sb.length());
		return str;
	}
}
