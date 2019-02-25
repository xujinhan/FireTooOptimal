package com.ht.app.base.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by ydd on 2017/4/11.
 */

public class GlideUtils {
    /**
     * Glide特点
     * 使用简单
     * 可配置度高，自适应程度高
     * 支持常见图片格式 Jpg png gif webp
     * 支持多种数据源  网络、本地、资源、Assets 等
     * 高效缓存策略    支持Memory和Disk图片缓存 默认Bitmap格式采用RGB_565内存使用至少减少一半
     * 生命周期集成   根据Activity/Fragment生命周期自动管理请求
     * 高效处理Bitmap  使用Bitmap Pool使Bitmap复用，主动调用recycle回收需要回收的Bitmap，减小系统回收压力
     * 这里默认支持Context，Glide支持Context,Activity,Fragment，FragmentActivity
     */
    //默认加载
    public static void loadImageView(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).into(mImageView);
    }

    //默认加载
    public static void loadImageView(Fragment mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).into(mImageView);
    }

    //设置加载失败图片
    public static void loadImageView(Context mContext, Object path, ImageView mImageView, int errorImageView) {
        RequestOptions options = new RequestOptions()
                .error(errorImageView);
        Glide.with(mContext)
                .load(path)
                .apply(options)
                .into(mImageView);
    }

    //设置加载失败图片
    public static void loadImageView(Fragment mContext, String path, ImageView mImageView, int errorImageView) {
        RequestOptions options = new RequestOptions()
                .error(errorImageView);
        Glide.with(mContext)
                .load(path)
                .apply(options)
                .into(mImageView);
    }


    //设置加载中以及加载失败图片
    public static void loadImageView(Context mContext, String path, ImageView mImageView, int lodingImage, int errorImageView) {
        RequestOptions options = new RequestOptions()
                .placeholder(lodingImage)
                .error(errorImageView);
        Glide.with(mContext)
                .load(path)
                .apply(options)
                .into(mImageView);
    }

    //设置options
    public static void loadImageView(Context mContext, String path, ImageView mImageView, RequestOptions options) {
        Glide.with(mContext)
                .load(path)
                .apply(options)
                .into(mImageView);
    }
}
