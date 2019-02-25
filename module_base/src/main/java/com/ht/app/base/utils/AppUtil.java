package com.ht.app.base.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 常用APP的工具类，包含版本号、版本名称、安装的应用程序ICON
 */
public class AppUtil {

    /**
     * 获取包名
     *
     * @param
     * @return
     */
    public static String getAppPackage() {
        return ContextUtil.getmCtx().getPackageName();
    }

    /**
     * 获取VersionCode(版本号)
     *
     * @param
     * @return 失败时返回-1
     */
    public static String getVersionCode() {
        PackageManager packageManager = getPackageManager(ContextUtil.getmCtx());
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getAppPackage(), 0);
            return packageInfo.versionCode + "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取VersionName(版本名称)
     *
     * @param context
     * @return 失败时返回""
     */
    public static String getVersionName(Context context) {
        PackageManager packageManager = getPackageManager(context);
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getAppPackage(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 获取所有安装的应用程序,不包含系统应用
     *
     * @param context
     * @return
     */
    public static List<PackageInfo> getInstalledPackages(Context context) {
        PackageManager packageManager = getPackageManager(context);
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        List<PackageInfo> packageInfoList = new ArrayList<PackageInfo>();
        for (int i = 0; i < packageInfos.size(); i++) {
            if ((packageInfos.get(i).applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                packageInfoList.add(packageInfos.get(i));
            }
        }
        return packageInfoList;
    }

    /**
     * 获取应用程序的icon图标
     *
     * @param context
     * @return 当包名错误时，返回null
     */
    public static Drawable getApplicationIcon(Context context) {
        PackageManager packageManager = getPackageManager(context);
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getAppPackage(), 0);
            return packageInfo.applicationInfo.loadIcon(packageManager);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 启动安装应用程序
     *
     * @param activity
     * @param path     应用程序路径
     */
    public static void installApk(Activity activity, String path) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(path)),
                "application/vnd.android.package-archive");
        activity.startActivity(intent);
    }

    /**
     * 获取PackageManager对象
     *
     * @param context
     * @return
     */
    private static PackageManager getPackageManager(Context context) {
        return context.getPackageManager();
    }

    /**
     * 当前应用是否在前端
     *
     * @return
     */
    public static boolean isTopActivity(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasksInfo = activityManager.getRunningTasks(1);
        if (tasksInfo.size() > 0) {
            //应用程序位于堆栈的顶层
            if (AppUtil.getAppPackage().equals(tasksInfo.get(0).topActivity.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    /***
     * 判断手机是否安装了微博
     ***/
    public static boolean isWeiboInstalled(Context context) {
        PackageManager pm;
        if ((pm = context.getPackageManager()) == null) {
            return false;
        }
        List<PackageInfo> packages = pm.getInstalledPackages(0);
        for (PackageInfo info : packages) {
            String name = info.packageName.toLowerCase(Locale.ENGLISH);
            if ("com.sina.weibo".equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取desity
     *
     * @return
     */
    public static float getDesity(Context context) {
        if (context != null) {
            WindowManager winMgr = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            // How to get all displays connected to the device?
            Display display = winMgr.getDefaultDisplay();
            DisplayMetrics outMetrics = new DisplayMetrics();
            display.getMetrics(outMetrics);
            return outMetrics.density;  // 屏幕密度（0.75 / 1.0 / 1.5）
        }
        return 1.0f;
    }

    /**
     * 获取手机屏幕的宽度
     *
     * @return
     */
    public static int getPhoneWidth(Context context) {
        if (context != null) {
            WindowManager wm = (WindowManager) context
                    .getSystemService(Context.WINDOW_SERVICE);
            return wm.getDefaultDisplay().getWidth();
            //int height = wm.getDefaultDisplay().getHeight();
        }
        return 0;
    }
}
