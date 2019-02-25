package com.ht.app.base.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description: 校验工具类
 * Author:YanDongDong
 * Data: 2018/5/17.
 */

public class RegexUtil {

    public static final String WXUSER = "[a-zA-Z0-9]{6,20}$";

    /**
     * 一个字符串是否全部都是数字
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 6到20位组成的密码（数字和字母）
     */
    public static boolean checkPasswd(String str) {
        return checkStr(WXUSER, str);
    }

    public static boolean checkStr(String pattern, String input) {
        if (input.isEmpty()) {
            return false;
        }
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        return m.matches();
    }
}
