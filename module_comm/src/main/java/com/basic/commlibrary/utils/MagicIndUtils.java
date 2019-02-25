package com.basic.commlibrary.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.basic.commlibrary.R;
import com.basic.commlibrary.imp.OnCustomListener;

import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgePagerTitleView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ydd
 * on 2017\8\28 0028.
 */

public class MagicIndUtils {


    public static void initMagicIndicator(Context context, final MagicIndicator magicIndicator, final ViewPager mViewPager, final int id, int size) {
        initMagicIndicator(context, magicIndicator, mViewPager, id, true, size);
    }

    public static void initMagicIndicator(Context context, final MagicIndicator magicIndicator, final ViewPager mViewPager, final int id, boolean average) {
        initMagicIndicator(context, magicIndicator, mViewPager, id, average, 13);
    }

    public static void initMagicIndicator(Context context, final MagicIndicator magicIndicator, final ViewPager mViewPager, final int id, boolean average, final int size) {
        final List<String> mTitleList = Arrays.asList(context.getResources().getStringArray(id));
        CommonNavigator commonNavigator = new CommonNavigator(context);
        commonNavigator.setAdjustMode(average);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitleList.size();
            }

            @Override
            public IPagerTitleView getTitleView(final Context context, final int index) {
                BadgePagerTitleView badgePagerTitleView = new BadgePagerTitleView(context);
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setNormalColor(context.getResources().getColor(R.color.t666666));
                simplePagerTitleView.setSelectedColor(context.getResources().getColor(R.color.tED1B24));
                simplePagerTitleView.setText(mTitleList.get(index));
                simplePagerTitleView.setTextSize(size);
                simplePagerTitleView.setPadding(0, 0, 0, 0);
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mViewPager != null) {
                            mViewPager.setCurrentItem(index);
                        }

                    }
                });
                badgePagerTitleView.setInnerPagerTitleView(simplePagerTitleView);
                return badgePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setColors(context.getResources().getColor(R.color.tED1B24));
                linePagerIndicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                linePagerIndicator.setLineHeight(UIUtil.dip2px(context, 1));
                linePagerIndicator.setYOffset(UIUtil.dip2px(context, 10));//设置距离底部的高度
                linePagerIndicator.setXOffset(UIUtil.dip2px(context, 3));
                return linePagerIndicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        if (mViewPager != null) {
            ViewPagerHelper.bind(magicIndicator, mViewPager);
        }
    }


    /**
     * 传入一个list 而不是array
     **/
    public static void initMagicIndicator(Context context, final MagicIndicator magicIndicator, final ViewPager mViewPager, final List<String> titleList, boolean average) {
        final List<String> mTitleList = titleList;
        CommonNavigator commonNavigator = new CommonNavigator(context);
        commonNavigator.setAdjustMode(average);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitleList.size();
            }

            @Override
            public IPagerTitleView getTitleView(final Context context, final int index) {
                BadgePagerTitleView badgePagerTitleView = new BadgePagerTitleView(context);
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setNormalColor(context.getResources().getColor(R.color.tbbbbbb));
                simplePagerTitleView.setSelectedColor(context.getResources().getColor(R.color.tFF6666));
                simplePagerTitleView.setText(mTitleList.get(index));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mViewPager != null) {
                            mViewPager.setCurrentItem(index);
                        }

                    }
                });
                badgePagerTitleView.setInnerPagerTitleView(simplePagerTitleView);
                return badgePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setColors(context.getResources().getColor(R.color.transparent));
                linePagerIndicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                linePagerIndicator.setLineHeight(UIUtil.dip2px(context, 1.5));
                linePagerIndicator.setYOffset(UIUtil.dip2px(context, 7));//设置距离底部的高度
                return linePagerIndicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        if (mViewPager != null) {
            ViewPagerHelper.bind(magicIndicator, mViewPager);
        }
    }


    public static void initMagicIndicator(Context context, MagicIndicator magicIndicator, final ViewPager mViewPager, final int id, final int size, boolean average) {
        final List<String> mTitleList = Arrays.asList(context.getResources().getStringArray(id));
        CommonNavigator commonNavigator = new CommonNavigator(context);
        commonNavigator.setAdjustMode(average);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return size;
            }

            @Override
            public IPagerTitleView getTitleView(final Context context, final int index) {
                BadgePagerTitleView badgePagerTitleView = new BadgePagerTitleView(context);
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setNormalColor(context.getResources().getColor(R.color.tbbbbbb));
                simplePagerTitleView.setSelectedColor(context.getResources().getColor(R.color.tFF6666));
                simplePagerTitleView.setText(mTitleList.get(index));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mViewPager != null) {
                            mViewPager.setCurrentItem(index);
                        }
                    }
                });
                badgePagerTitleView.setInnerPagerTitleView(simplePagerTitleView);
                return badgePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setColors(context.getResources().getColor(R.color.transparent));
                linePagerIndicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                linePagerIndicator.setLineHeight(UIUtil.dip2px(context, 1.5));
                linePagerIndicator.setYOffset(UIUtil.dip2px(context, 7));//设置距离底部的高度
                return linePagerIndicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        if (mViewPager != null) {
            ViewPagerHelper.bind(magicIndicator, mViewPager);
        }
    }

    /**
     * 不搭配viewpager
     */
    public static void initMagicNoViewPager(final Context context, MagicIndicator magicIndicator, final FragmentContainerHelper mFragmentContainerHelper, int id, final OnCustomListener listener) {
        final List<String> mTitleList = Arrays.asList(context.getResources().getStringArray(id));
        CommonNavigator commonNavigator = new CommonNavigator(context);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitleList.size();
            }

            @Override
            public IPagerTitleView getTitleView(final Context contexts, final int index) {
                ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);
                clipPagerTitleView.setText(mTitleList.get(index));
                clipPagerTitleView.setTextSize(UIUtil.dip2px(context, 15));
                clipPagerTitleView.setTextColor(context.getResources().getColor(R.color.t666666));
                clipPagerTitleView.setClipColor(context.getResources().getColor(R.color.tED1B24));
                clipPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mFragmentContainerHelper.handlePageSelected(index);
                        if (listener != null) {
                            listener.onCustomerListener(null, index);
                        }
                    }
                });
                return clipPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setColors(context.getResources().getColor(R.color.transparent));
                linePagerIndicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                linePagerIndicator.setLineHeight(UIUtil.dip2px(context, 1));
                linePagerIndicator.setLineWidth(UIUtil.dip2px(context, 20));
                linePagerIndicator.setYOffset(UIUtil.dip2px(context, 10));//设置距离底部的高度
                linePagerIndicator.setColors(context.getResources().getColor(R.color.tED1B24));
                return linePagerIndicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        mFragmentContainerHelper.attachMagicIndicator(magicIndicator);
    }

    /**
     * 中间有分割线的magic
     */
    public static void initMagicHavaDiver(Context context, MagicIndicator magicIndicator, final ViewPager mViewPager, int id) {
        final List<String> mDataList = Arrays.asList(context.getResources().getStringArray(id));
        CommonNavigator commonNavigator = new CommonNavigator(context);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setText(mDataList.get(index));
                simplePagerTitleView.setTextSize(15);
                simplePagerTitleView.setNormalColor(context.getResources().getColor(R.color.t666666));
                simplePagerTitleView.setSelectedColor(context.getResources().getColor(R.color.tED1B24));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setLineHeight(UIUtil.dip2px(context, 1));
                indicator.setLineWidth(UIUtil.dip2px(context, 20));
                indicator.setYOffset(UIUtil.dip2px(context, 10));//设置距离底部的高度
                indicator.setColors(context.getResources().getColor(R.color.tED1B24));
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        titleContainer.setDividerDrawable(context.getResources().getDrawable(R.drawable.simple_splitter));
        ViewPagerHelper.bind(magicIndicator, mViewPager);
    }

    /**
     * 中间有分割线的magic
     */
    public static void initMagicHavaDiver(Context context, final MagicIndicator magicIndicator, int id, final OnCustomListener listener) {
        final List<String> mDataList = Arrays.asList(context.getResources().getStringArray(id));
        CommonNavigator commonNavigator = new CommonNavigator(context);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setText(mDataList.get(index));
                simplePagerTitleView.setTextSize(15);
                simplePagerTitleView.setNormalColor(context.getResources().getColor(R.color.t999999));
                simplePagerTitleView.setSelectedColor(context.getResources().getColor(R.color.tFF6161));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        magicIndicator.onPageSelected(index);
                        if (listener != null) {
                            listener.onCustomerListener(v, index);
                        }
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setLineHeight(5);
                indicator.setColors(context.getResources().getColor(R.color.tFF6161));
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        titleContainer.setDividerDrawable(context.getResources().getDrawable(R.drawable.simple_splitter));
    }

}
