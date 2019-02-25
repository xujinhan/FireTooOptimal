package com.ht.app.base.utils;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by ydd
 * on 2017\9\1 0001.
 */

public class RecycleUtils {
    /**
     * RecyclerView 移动到当前位置，
     *
     * @param manager       设置RecyclerView对应的manager
     * @param mRecyclerView 当前的RecyclerView
     * @param n             要跳转的位置
     */
    public static void MoveToPosition(GridLayoutManager manager, RecyclerView mRecyclerView, int n) {
        int firstItem = manager.findFirstVisibleItemPosition();
        int lastItem = manager.findLastVisibleItemPosition();
        if (n <= firstItem) {
            mRecyclerView.scrollToPosition(n);
        } else if (n <= lastItem) {
            int top = mRecyclerView.getChildAt(n - firstItem).getTop();
            mRecyclerView.scrollBy(0, top);
        } else {
            mRecyclerView.scrollToPosition(n);
        }
    }

    /**
     * linear的配置
     **/
    public static void initXLin(Context context, RecyclerView superRecyclerView) {
        initXLin(context, superRecyclerView, 1, null, 0);
    }

    /**
     * linear的配置
     **/
    public static void initXLin(Context context, RecyclerView superRecyclerView, int type) {
        initXLin(context, superRecyclerView, type, null, 0);
    }

    /**
     * linear的配置(可设置横向竖向)
     **/
    public static void initXLin(Context context, RecyclerView mRecyclerView, int type, ImageView topImageView, int num) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setAutoMeasureEnabled(true);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        if (type == 0) {
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        } else {
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        }
        mRecyclerView.setLayoutManager(layoutManager);
        if (topImageView != null) {
            addListener(mRecyclerView, layoutManager, topImageView, num);
        }
    }

    /**
     * linear的配置（默认竖向）
     **/
    public static void initXLin(Context context, RecyclerView mRecyclerView, ImageView topImageView, int num) {
        initXLin(context, mRecyclerView, 1, topImageView, num);
    }

    /**
     * linear的配置（默认竖向）
     * 滑动距离超过多少个item 显示topview
     **/
    public static void initXLin(Context context, RecyclerView mRecyclerView, ImageView topImageView) {
        initXLin(context, mRecyclerView, topImageView, 1);
    }

    public static void addListener(final RecyclerView mRecyclerView, final LinearLayoutManager layoutManager, final ImageView image, final int num) {
        if (image != null) {
            mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    if (layoutManager.findFirstVisibleItemPosition() > num) {
                        image.setVisibility(View.VISIBLE);
                    } else {
                        image.setVisibility(View.GONE);
                    }
                }
            });
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRecyclerView.smoothScrollToPosition(0);
                }
            });
        }
    }

    /**
     * grid的配置(可设置横向竖向)
     **/
    public static void initGrid(Context context, RecyclerView mRecyclerView, int num) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, num);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
    }
}
