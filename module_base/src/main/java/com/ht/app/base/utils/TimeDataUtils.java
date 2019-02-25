package com.ht.app.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ydd
 * on 2017\8\22 0022.
 */

public class TimeDataUtils {


    /**
     * 自定义格式化显示的时长
     *
     * @param seconds
     * @return
     */
    public static String getDate(long seconds, String format) {
        long millisecond = seconds;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date(millisecond));
    }


    /**
     * 对带有T的时间格式，进行格式化
     *
     * @param
     * @return
     */
    public static String formatTDate(String time) {
        if (time.contains("T")) {
            time = time.replaceAll("T", " ");
        }
        return time;
    }

    /**
     * 获取当前时间的💰前几天（-）或者后几天（+）
     *
     * @param
     * @return
     */
    public static String getDateBySpaceDay(int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return sdf.format(calendar.getTime());
    }

    /**
     * 格式化显示的时长
     *
     * @param seconds
     * @return
     */
    public static String getMDHMDate(long seconds) {
        long millisecond = seconds * 1000;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM月dd日 HH:mm");
        return dateFormat.format(new Date(millisecond));
    }

    /**
     * 格式化显示的时长
     *
     * @param seconds
     * @return
     */
    public static String getDHMSDate(long seconds) {
        long millisecond = seconds * 1000;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd天:HH时:mm分:ss秒");
        return dateFormat.format(new Date(millisecond));
    }

    /**
     * 格式化显示的时长
     *
     * @param seconds
     * @return
     */
    public static String getHMSDate(long seconds) {
        long millisecond = seconds * 1000;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(new Date(millisecond));
    }

    /**
     * 格式化显示的时长
     *
     * @param seconds
     * @return
     */
    public static String getMDDate(long seconds) {
        long millisecond = seconds * 1000;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM月dd日");
        return dateFormat.format(new Date(millisecond));
    }

    /**
     * 格式化显示的时长
     *
     * @param seconds
     * @return
     */
    public static String getYMDDate(long seconds) {
        long millisecond = seconds * 1000;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        return dateFormat.format(new Date(millisecond));
    }

    /**
     * 格式化显示的时长
     *
     * @param seconds
     * @return
     */
    public static String getYMD2Date(long seconds) {
        long millisecond = seconds * 1000;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date(millisecond));
    }

    /**
     * 格式化显示的时长
     *
     * @param seconds
     * @return
     */
    public static String getYMDHMSDate(long seconds) {
        long millisecond = seconds * 1000;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date(millisecond));
    }

    /**
     * 格式化显示的时长
     *
     * @param seconds
     * @return
     */
    public static String getYMDHMSDate2(long seconds) {
        long millisecond = seconds * 1000;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return dateFormat.format(new Date(millisecond));
    }

    /**
     * 格式化显示的时长
     *
     * @param seconds
     * @return
     */
    public static String getYMDHMDate2(long seconds) {
        long millisecond = seconds * 1000;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        return dateFormat.format(new Date(millisecond));
    }

    /**
     * 格式化显示的时长
     *
     * @param seconds
     * @return
     */
    public static String getYMDHMDate(long seconds) {
        long millisecond = seconds * 1000;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return dateFormat.format(new Date(millisecond));
    }

    /**
     * 格式化显示的时长
     *
     * @param seconds
     * @return
     */
    public static String getYMDDate2(long seconds) {
        long millisecond = seconds * 1000;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        return dateFormat.format(new Date(millisecond));
    }

    /**
     * 时间转换成时间戳
     *
     * @param
     * @return
     */
    public static String dateToStamp(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.valueOf(date.getTime() / 1000);
    }


    /**
     * 输入时间戳变星期
     *
     * @param time
     * @return
     */
    public static String changeWeek(long time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String times = sdr.format(new Date(time * 1000L));
        Date date = null;
        int mydate = 0;
        String week = null;
        try {
            date = sdr.parse(times);
            Calendar cd = Calendar.getInstance();
            cd.setTime(date);
            mydate = cd.get(Calendar.DAY_OF_WEEK);
            // 获取指定日期转换成星期几
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (mydate == 1) {
            week = "星期日";
        } else if (mydate == 2) {
            week = "星期一";
        } else if (mydate == 3) {
            week = "星期二";
        } else if (mydate == 4) {
            week = "星期三";
        } else if (mydate == 5) {
            week = "星期四";
        } else if (mydate == 6) {
            week = "星期五";
        } else if (mydate == 7) {
            week = "星期六";
        }
        return week;
    }

    /***
     * 秒转换为 天，时，分，秒
     * **/
    public static String getCountTimeByInt(int totalTime) {
        int day = 0, hour = 0, minute = 0, second = 0;

        if (3600 * 24 <= totalTime) {
            day = totalTime / (3600 * 24);
            totalTime = totalTime - 3600 * 24 * day;
        }
        if (3600 <= totalTime) {
            hour = totalTime / 3600;
            totalTime = totalTime - 3600 * hour;
        }
        if (60 <= totalTime) {
            minute = totalTime / 60;
            totalTime = totalTime - 60 * minute;
        }
        if (0 <= totalTime) {
            second = totalTime;
        }
        StringBuilder sb = new StringBuilder();

        if (day < 10) {
            sb.append("0").append(day).append("天");
        } else {
            sb.append(day).append("天");
        }
        if (hour < 10) {
            sb.append("0").append(hour).append("时");
        } else {
            sb.append(hour).append("时");
        }
        if (minute < 10) {
            sb.append("0").append(minute).append("分");
        } else {
            sb.append(minute).append("分");
        }
        if (second < 10) {
            sb.append("0").append(second);
        } else {
            sb.append(second);
        }
        return sb.toString();
    }

    /***
     * 秒转换为时，分，秒
     * **/
    public static String changeTimeByInt(int second) {
        int h = 0;
        int d = 0;
        int s = 0;
        String hr = "";
        String dr = "";
        String sr = "";
        int temp = second % 3600;
        if (second > 3600) {
            h = second / 3600;
            if (temp != 0) {
                if (temp > 60) {
                    d = temp / 60;
                    if (temp % 60 != 0) {
                        s = temp % 60;
                    }
                } else {
                    s = temp;
                }
            }
        } else {
            d = second / 60;
            if (second % 60 != 0) {
                s = second % 60;
            }
        }

        hr = h < 10 ? "0" + h : h + "";
        dr = d < 10 ? "0" + d : d + "";
        sr = s < 10 ? "0" + s : s + "";
        return hr + ":" + dr + ":" + sr + "";
    }
}
