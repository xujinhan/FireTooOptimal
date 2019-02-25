package com.ht.app.base.utils;

import android.widget.Toast;

/**
 * Description:
 * Author: ydd
 * Date:2018/7/30
 */
public class Toasts {
    public static void showToast(int text) {
        showToast(ContextUtil.getmCtx().getText(text).toString());
    }

    public static void showToast(String text) {
        Toast.makeText(ContextUtil.getmCtx(), text, Toast.LENGTH_SHORT).show();
    }
}
