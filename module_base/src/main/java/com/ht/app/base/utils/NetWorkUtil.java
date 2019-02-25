package com.ht.app.base.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.view.WindowManager;

/**
 * 网络工具类，包含网络的判断、跳转到设置页面
 */
public class NetWorkUtil {
    /**
     * 判断当前是否有网络连接
     *
     * @param
     * @return 有网络返回true；无网络返回false
     */
    @SuppressWarnings("null")
    public static boolean isNetWorkEnable() {
        ConnectivityManager manager = (ConnectivityManager) ContextUtil.getmCtx().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断当前网络是否为wifi
     *
     * @param
     * @return 如果为wifi返回true；否则返回false
     */
    @SuppressWarnings("static-access")
    public static boolean isWiFiConnected() {
        ConnectivityManager manager = (ConnectivityManager) ContextUtil.getmCtx().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (!isNetWorkEnable()) {
            return false;
        }
        return networkInfo.getType() == manager.TYPE_WIFI ? true : false;
    }

    /**
     * 判断MOBILE网络是否可用
     *
     * @param
     * @return
     * @throws Exception
     */
    public static boolean isMobileDataEnable() {
        ConnectivityManager manager = (ConnectivityManager) ContextUtil.getmCtx().getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean isMobileDataEnable = false;
        isMobileDataEnable = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
        return isMobileDataEnable;
    }

    /**
     * 判断wifi 是否可用
     *
     * @param
     * @return
     * @throws Exception
     */
    public static boolean isWifiDataEnable() {
        ConnectivityManager manager = (ConnectivityManager) ContextUtil.getmCtx().getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean isWifiDataEnable = false;
        isWifiDataEnable = manager.getNetworkInfo(
                ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
        return isWifiDataEnable;
    }

    /**
     * 跳转到网络设置页面
     *
     * @param activity
     */
    public static void GoSetting(Activity activity) {
        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        activity.startActivity(intent);
    }

    /**
     * 打开网络设置界面
     */
    public static void openSetting(Activity activity) {
        Intent intent = new Intent("/");
        ComponentName cn = new ComponentName("com.android.settings", "com.android.settings.WirelessSettings");
        intent.setComponent(cn);
        intent.setAction("android.intent.action.VIEW");
        activity.startActivityForResult(intent, 0);
    }
    /**
     * 设置全局监听网络
     */
    static Dialog dialog;
    public static void initNetWork(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isAvailable()) {//当前网络可用
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                } else {//当前网络不可用
                    dialog = NetWorkUtil.showNoNetWorkDilaog();
                }
            }
        }, intentFilter);
    }

    /**
     * 没网的提示框
     */
    public static Dialog showNoNetWorkDilaog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ContextUtil.getmCtx());
        AlertDialog dialog = builder.setTitle("提示")
                .setMessage("联网失败,请检查网络")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
        dialog.setCanceledOnTouchOutside(false);
        if (!dialog.isShowing()) {
            dialog.show();
        }
        return dialog;
    }
}