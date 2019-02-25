package com.ht.app.base.weight;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;

/**
 * Created by ydd on 2017/12/25.
 * 适配7.0 和8.0 的位置显示错误
 */

public class NewPopuPWindow extends PopupWindow {
    public NewPopuPWindow(View mMenuView, int matchParent, int matchParent1) {
        super(mMenuView, matchParent,matchParent1);
    }

    @Override
    public void showAsDropDown(View anchor) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            anchor.getGlobalVisibleRect(rect);
            int h = anchor.getResources().getDisplayMetrics().heightPixels - rect.bottom;
            setHeight(h);
        }
        super.showAsDropDown(anchor);
    }
}
