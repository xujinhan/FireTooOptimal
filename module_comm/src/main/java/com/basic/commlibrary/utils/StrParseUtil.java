package com.basic.commlibrary.utils;

import android.text.TextUtils;

/**
 * 字符串类型转化成其他基本类型，byte、short、char不常用，所以暂时不处理
 * 
 * @author lanyan
 * 
 */
public class StrParseUtil {
	public static float parseFloat(String string) {
		if (TextUtils.isEmpty(string)) {
			return 0;
		}
		try {
			return Float.parseFloat(string);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static int parseInt(String string) {
		if (TextUtils.isEmpty(string)) {
			return 0;
		}
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static double parseDouble(String string) {
		if (TextUtils.isEmpty(string)) {
			return 0;
		}
		try {
			return Double.parseDouble(string);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static long parseLong(String string) {
		if (TextUtils.isEmpty(string)) {
			return 0;
		}
		try {
			return Long.parseLong(string);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static boolean parseBoolean(String string) {
		if (TextUtils.isEmpty(string)) {
			return false;
		}
		try {
			return Boolean.parseBoolean(string);
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean equal(String compare, String obj) {
		if (TextUtils.isEmpty(compare)) {
			return false;
		}

		return compare.equals(obj);
	}

}
