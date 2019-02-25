package com.ht.app.base.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ht.app.base.R;

/**
 * Created by ydd on 2017/4/13.
 * 头部view
 */

public class MyTitleView extends RelativeLayout {
    protected Context mContext;
    private ViewGroup mLayout;

    public MyTitleView(Context context) {
        super(context, null);
    }

    public MyTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        mLayout = (ViewGroup) inflater.inflate(R.layout.titleview, this, true);
    }

    public RelativeLayout getRootsView() {
        return (RelativeLayout) mLayout.findViewById(R.id.root_layout_view);
    }

    public ImageView getLeftView() {
        return (ImageView) mLayout.findViewById(R.id.left_view_img);
    }

    public AlwaysMarqueeScrollView getCenterView() {
        return (AlwaysMarqueeScrollView) mLayout.findViewById(R.id.center_view_tv);
    }

    public ImageView getRightImgView() {
        return (ImageView) mLayout.findViewById(R.id.right_img);
    }


    public TextView getRighTextView() {
        return (TextView) mLayout.findViewById(R.id.right_tv);
    }
}
