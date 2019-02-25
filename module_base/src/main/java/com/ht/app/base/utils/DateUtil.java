package com.ht.app.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2018/3/20.
 * 日期工具类
 */

public class DateUtil {

    private DateUtil() {
    }

    /**
     * 枚举日期格式
     */
    public enum DatePattern {
        /**
         * 格式："yyyy-MM-dd HH:mm:ss"
         */
        ALL_TIME {
            public String getValue() {
                return "yyyy-MM-dd HH:mm:ss";
            }
        },
        /**
         * 格式："yyyy-MM"
         */
        ONLY_MONTH {
            public String getValue() {
                return "yyyy-MM";
            }
        },
        /**
         * 格式："yyyy-MM-dd"
         */
        ONLY_DAY {
            public String getValue() {
                return "yyyy-MM-dd";
            }
        },
        /**
         * 格式："yyyy-MM-dd HH"
         */
        ONLY_HOUR {
            public String getValue() {
                return "yyyy-MM-dd HH";
            }
        },
        /**
         * 格式："yyyy-MM-dd HH:mm"
         */
        ONLY_MINUTE {
            public String getValue() {
                return "yyyy-MM-dd HH:mm";
            }
        },
        /**
         * 格式："MM-dd"
         */
        ONLY_MONTH_DAY {
            public String getValue() {
                return "MM-dd";
            }
        },
        /**
         * 格式："MM-dd HH:mm"
         */
        ONLY_MONTH_SEC {
            public String getValue() {
                return "MM-dd HH:mm";
            }
        },
        /**
         * 格式："HH:mm:ss"
         */
        ONLY_TIME {
            public String getValue() {
                return "HH:mm:ss";
            }
        },
        /**
         * 格式："HH:mm"
         */
        ONLY_HOUR_MINUTE {
            public String getValue() {
                return "HH:mm";
            }
        };

        public abstract String getValue();
    }

    /**
     * 获取当前时间
     *
     * @return 返回当前时间，格式2017-05-04	10:54:21
     */
    public static String getNowDate(DatePattern pattern) {
        String dateString = null;
        Calendar calendar = Calendar.getInstance();
        Date dateNow = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern.getValue(), Locale.CHINA);
        dateString = sdf.format(dateNow);
        return dateString;
    }

    /**
     * 将一个日期字符串转换成Data对象
     *
     * @param dateString 日期字符串
     * @param pattern    转换格式
     * @return 返回转换后的日期对象
     */
    public static Date stringToDate(String dateString, DatePattern pattern) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern.getValue(), Locale.CHINA);
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将date转换成字符串
     *
     * @param date    日期
     * @param pattern 日期的目标格式
     * @return
     */
    public static String dateToString(Date date, DatePattern pattern) {
        String string = "";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern.getValue(), Locale.CHINA);
        string = sdf.format(date);
        return string;
    }

    /**
     * 获取指定日期周几
     *
     * @param date 指定日期
     * @return 返回值为： "周日", "周一", "周二", "周三", "周四", "周五", "周六"
     */
    public static String getWeekOfDate(Date date) {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (week < 0)
            week = 0;
        return weekDays[week];
    }

    /**
     * 获取指定日期对应周几的序列
     *
     * @param date 指定日期
     * @return 周一：1	周二：2	周三：3	周四：4	周五：5	周六：6	周日：7
     */
    public static int getIndexWeekOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int index = calendar.get(Calendar.DAY_OF_WEEK);
        if (index == 1) {
            return 7;
        } else {
            return --index;
        }
    }

    /**
     * 返回当前月份
     *
     * @return
     */
    public static int getNowMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当前月号
     *
     * @return
     */
    public static int getNowDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取当前年份
     *
     * @return
     */
    public static int getNowYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取本月份的天数
     *
     * @return
     */
    public static int getNowDaysOfMonth() {
        Calendar calendar = Calendar.getInstance();
        return daysOfMonth(calendar.get(Calendar.YEAR), calendar.get(Calendar.DATE) + 1);
    }

    /**
     * 获取指定月份的天数
     *
     * @param year  年份
     * @param month 月份
     * @return 对应天数
     */
    public static int daysOfMonth(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if ((year % 4 == 0 && year % 100 == 0) || year % 400 != 0) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;
        }
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
