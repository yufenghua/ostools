package com.fenghua.ostools.util;

/**
 * 字符串相关工具类
 * 
 * @author fenghua
 * 
 */
public class StrUtils {
	public static final String NULL_STR = "";

	private StrUtils() {
	}

	/**
	 * 判斷字符串是不是空（包括空字符串）
	 * 
	 * @param str
	 * @return
	 */
	public static final boolean isNullStr(String str) {
		return str == null ? true : NULL_STR.equals(str);
	}

	/**
	 * 字符串转成int
	 * 
	 * @param str
	 *            字符串
	 * @param def
	 *            默认值
	 * @return 能转成int 转成int 不能，转成默认值
	 */
	public static int parseToInt(String str, int def) {
		if (isNullStr(str)) {
			return def;
		}
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			// TODO 异常处理
			e.printStackTrace();
			return def;
		}
	}
}
