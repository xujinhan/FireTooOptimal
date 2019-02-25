package com.ht.app.base.utils;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;

/**
 * Created by ydd
 * on 2017\9\10 0010.
 * superRecycleView的基本设置
 */

public class SuperRecycleUtils {
    /**
     * linear的配置
     **/
    public static void initXLin(Context context, SuperRecyclerView superRecyclerView) {
        initXLin(context, superRecyclerView, 1);
    }

    /**
     * linear的配置
     **/
    public static void initXLin(Context context, SuperRecyclerView superRecyclerView, int type) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        if (type == 0) {
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        } else {
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        }
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);

        superRecyclerView.setLayoutManager(layoutManager);
        superRecyclerView.setHasFixedSize(true);
        superRecyclerView.setNestedScrollingEnabled(false);
        superRecyclerView.setRefreshProgressStyle(com.superrecycleview.superlibrary.recycleview.ProgressStyle.BallSpinFadeLoader);// 下拉刷新的样式
        superRecyclerView.setLoadingMoreProgressStyle(com.superrecycleview.superlibrary.recycleview.ProgressStyle.BallClipRotate);// 上拉加载的样式
//        superRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);// 设置下拉箭头
    }

    /**
     * linear的配置
     **/
    public static void initXLinAddListener(Context context, SuperRecyclerView superRecyclerView, ImageView topView) {
        initXLin(context, superRecyclerView);
        addListener(superRecyclerView, topView);
    }

    /**
     * gird的配置
     **/
    public static void initXGird(Context context, SuperRecyclerView superRecyclerView, int num) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, num);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        superRecyclerView.setLayoutManager(layoutManager);
        superRecyclerView.setRefreshProgressStyle(com.superrecycleview.superlibrary.recycleview.ProgressStyle.BallSpinFadeLoader);// 下拉刷新的样式
        superRecyclerView.setLoadingMoreProgressStyle(com.superrecycleview.superlibrary.recycleview.ProgressStyle.BallClipRotate);// 上拉加载的样式
//        superRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);// 设置下拉箭头
    }

    /**
     * gird的配置
     **/
    public static void initGridAddListener(Context context, SuperRecyclerView superRecyclerView, int num, ImageView topView) {
        initXGird(context, superRecyclerView, num);
        addListener(superRecyclerView, topView);
    }

    public static void addListener(final SuperRecyclerView mRecyclerView, final ImageView image) {
        if (image != null) {
            mRecyclerView.setScrollAlphaChangeListener(new SuperRecyclerView.ScrollAlphaChangeListener() {
                @Override
                public void onAlphaChange(int alpha) {
                    if (alpha == 255) {
                        image.setVisibility(View.VISIBLE);
                    } else {
                        image.setVisibility(View.GONE);
                    }
                }

                @Override
                public int setLimitHeight() {
                    return 1000;
                }
            });

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRecyclerView.scrollToPosition(0);
                }
            });
        }
    }
}
