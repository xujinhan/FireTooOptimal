package com.ht.app.base.weight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author wqf
 *         TextView不用获取焦点也能自动实现跑马灯
 */
@SuppressLint("AppCompatCustomView")
public class AlwaysMarqueeScrollView extends TextView {

    public AlwaysMarqueeScrollView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public AlwaysMarqueeScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public AlwaysMarqueeScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isFocused() {
        return true;
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        // TODO Auto-generated method stub
        // fobid call parent constructor
        // super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

}
