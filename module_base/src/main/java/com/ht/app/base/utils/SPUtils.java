package com.ht.app.base.utils;
import com.ht.app.base.manager.SPManager;

import java.util.Map;

/**
 * Created by ydd on 2018/1/15.
 * sp的工具类
 */

public class SPUtils {
    private static final SPManager SP_UTILS = SPManager.getInstance();

    public static void setString(String key, String value) {
        SP_UTILS.put(key, value);
    }

    public static String getString(String key) {
        return SP_UTILS.getString(key);
    }

    public static void setInt(String key, int value) {
        SP_UTILS.put(key, value);
    }

    public static int getInt(String key) {
        return SP_UTILS.getInt(key);
    }

    public static void setLong(String key, long value) {
        SP_UTILS.put(key, value);
    }

    public static long getLong(String key) {
        return SP_UTILS.getLong(key);
    }

    public static void setFloat(String key, float value) {
        SP_UTILS.put(key, value);
    }

    public static float getFloat(String key) {
        return SP_UTILS.getFloat(key);
    }

    public static void setBoolean(String key, boolean value) {
        SP_UTILS.put(key, value);
    }

    public static boolean getBoolean(String key) {
        return SP_UTILS.getBoolean(key);
    }

    public static void clear() {
        SP_UTILS.clear();
    }

    public static void remove(String key) {
        SP_UTILS.remove(key);
    }

    public static String sp2String() {
        StringBuilder sb = new StringBuilder();
        Map<String, ?> map = SP_UTILS.getAll();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            sb.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append("\n");
        }
        return sb.toString();
    }
}
