package com.basic.commlibrary.utils;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;

import com.alibaba.android.arouter.launcher.ARouter;
import com.basic.commlibrary.R;
import com.basic.commlibrary.config.ARoutePaths;

import java.io.File;
import java.math.BigDecimal;

/**
 * Description:工具类
 * Author: ydd
 * Date:2018/8/1
 */
public class MyUtils {

    //进行跳转
    public static void GoPath(String path) {
        GoPath(path, null);
    }

    public static void GoPath(String path, Bundle bundle) {
        ARouter.getInstance().build(path).with(bundle).navigation();
    }

    public static void GoPath(Context context, String path, int code) {
        GoPath(context, path, null, code);
    }

    public static void GoPath(Context context, String path, Bundle bundle, int code) {
        ARouter.getInstance().build(path).with(bundle).navigation((Activity) context, code);
    }

    /**
     * 去web加载
     **/
    public static void goWebAc(String title, String url) {
        Bundle bundle = new Bundle();
        bundle.putString("webTitle", title);
        bundle.putString("webUrl", url);
        GoPath(ARoutePaths.WebAc, bundle);
    }

    /**
     * 密文显示银行卡号前面的数字
     **/
    public static String hindBank(String bankCard) {
        char[] bankArray = bankCard.toCharArray();
        String bankString = "";
        for (int i = 0; i < bankArray.length; i++) {
            if (i % 4 == 0 && i > 0) {
                bankString += " ";
            }
            bankString += bankArray[i];
        }
        char[] bArray = bankString.toCharArray();
        if (bankArray.length >= 14) {
            for (int i = 0; i < 14; i++) {
                if (bArray[i] != ' ') {
                    bArray[i] = '*';
                }
            }
        }
        return new String(bArray);
    }

    /**
     * 密文显示身份证号中间的数字
     **/
    public static String hindIDNumber(String idCard) {

        char[] idArray = isEmpty(idCard).toCharArray();
        if (idArray.length >= 2) {
            for (int i = 1; i < (idArray.length - 1); i++) {
                idArray[i] = '*';
            }
        }
        return new String(idArray);
    }

    /**
     * 吧double转变成一个小数点两位的string 会四舍五入
     **/
    public static String doubleToStr2(double value) {
        BigDecimal b = new BigDecimal(value);
        return b.setScale(2, BigDecimal.ROUND_HALF_UP) + "";
    }

    public static String isEmpty(String string) {
        if (!TextUtils.isEmpty(string)) {
            return string;
        } else {
            return "";
        }
    }

    /**
     * 获取折后价
     *
     * @return
     */
    public static String getDiscountedPrice(double price, double discount) {
        return MyUtils.doubleToStr2(discount / 10 * price);
    }


    /**
     * 复制到剪切板
     *
     * @param context
     */
    public static void copy(Context context, String text) {
        // 得到剪贴板管理器
        ClipboardManager cmb = (ClipboardManager) context
                .getSystemService(Context.CLIPBOARD_SERVICE);
        cmb.setText(text);
    }


    /**
     * 安装 apk 文件
     *
     * @param filepath
     */
    public static void installApk(Context context, String filepath) {

        File apkFile = new File(filepath);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {//判读版本是否在7.0以上
            Uri apkUri = FileProvider.getUriForFile(context.getApplicationContext(), context.getApplicationContext().getPackageName() + ".provider", apkFile);//在AndroidManifest中的android:authorities值
            Intent install = new Intent(Intent.ACTION_VIEW);
            install.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            install.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);//添加这一句表示对目标应用临时授权该Uri所代表的文件
            install.setDataAndType(apkUri, "application/vnd.android.package-archive");
            context.startActivity(install);
        } else {
            Uri uri = Uri.fromFile(apkFile);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
    }


    /***
     * 时间戳转换为 天，时，分，秒
     * @param finishTime 倒计时的时间
     ***/
    public static SpannableStringBuilder getCountTimeByLong(Context context, long finishTime) {
        long totalTime = (long) (finishTime / 1000);//秒
        long day = 0, hour = 0;
        long minute = 0, second = 0;

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

        int beforeLocation = 0;
        SpannableStringBuilder sb = new SpannableStringBuilder();
//        StringBuilder sb = new StringBuilder();
        beforeLocation = sb.length();
        if (day < 10) {
            sb.append("0").append(String.valueOf(day)).append("天");
        } else {
            sb.append(String.valueOf(day)).append("天");
        }
        sb.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.tF8E71C)),
                beforeLocation, sb.length() - 1, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        beforeLocation = sb.length();
        if (hour < 10) {
            sb.append("0").append(String.valueOf(hour)).append("时");
        } else {
            sb.append(String.valueOf(hour)).append("时");
        }
        sb.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.tF8E71C)),
                beforeLocation, sb.length() - 1, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        beforeLocation = sb.length();
        if (minute < 10) {
            sb.append("0").append(String.valueOf(minute)).append("分");
        } else {
            sb.append(String.valueOf(minute)).append("分");
        }
        sb.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.tF8E71C)),
                beforeLocation, sb.length() - 1, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        beforeLocation = sb.length();
        if (second < 10) {
            sb.append("0").append(String.valueOf(second)).append("秒");
        } else {
            sb.append(String.valueOf(second)).append("秒");
        }
        sb.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.tF8E71C)),
                beforeLocation, sb.length() - 1, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        return sb;
    }
}
