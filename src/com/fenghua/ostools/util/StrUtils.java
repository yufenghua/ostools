package com.fenghua.ostools.util;

/**
 * �ַ�����ع�����
 * 
 * @author fenghua
 * 
 */
public class StrUtils {
	public static final String NULL_STR = "";

	private StrUtils() {
	}

	/**
	 * �Д��ַ����ǲ��ǿգ��������ַ�����
	 * 
	 * @param str
	 * @return
	 */
	public static final boolean isNullStr(String str) {
		return str == null ? true : NULL_STR.equals(str);
	}

	/**
	 * �ַ���ת��int
	 * 
	 * @param str
	 *            �ַ���
	 * @param def
	 *            Ĭ��ֵ
	 * @return ��ת��int ת��int ���ܣ�ת��Ĭ��ֵ
	 */
	public static int parseToInt(String str, int def) {
		if (isNullStr(str)) {
			return def;
		}
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			// TODO �쳣����
			e.printStackTrace();
			return def;
		}
	}
}
