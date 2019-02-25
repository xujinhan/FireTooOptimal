package com.ht.app.base.utils;

import android.Manifest;
import android.app.Activity;
import android.widget.Toast;

import com.ht.app.base.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;
import com.luck.picture.lib.tools.PictureFileUtils;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ydd
 * on 2017\9\27 0027.
 * 图片选择器
 */

public class PicSeletorUtils {
    public static void GetPerAndClearCache(final Activity context) {
        // 清空图片缓存，包括裁剪、压缩后的图片 注意:必须要在上传完成后调用 必须要获取权限
        RxPermissions permissions = new RxPermissions(context);
        permissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Boolean aBoolean) {
                if (aBoolean) {
                    PictureFileUtils.deleteCacheDirFile(context);
                } else {
                    Toast.makeText(context, context.getString(R.string.picture_jurisdiction), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }

    public static void initGalleryPic(final Activity context, boolean isHead) {
        initGalleryPic(context, 1, null, true, isHead);
    }

    public static void initGalleryPic(final Activity context, final int maxSelectNum, final List<LocalMedia> selectList) {
        initGalleryPic(context, maxSelectNum, selectList, true, false);
    }

    /***
     * 单选多选配置
     * **/
    public static void initGalleryPic(final Activity context, final int maxSelectNum, final List<LocalMedia> selectList, final boolean isCrop, final boolean isHead) {
        int mode;
        if (maxSelectNum == 1) {
            mode = PictureConfig.SINGLE;
        } else {
            mode = PictureConfig.MULTIPLE;
        }
        PictureSelector.create(context)
                .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .theme(R.style.picture_default_style)// 主题样式设置 具体参考 values/styles   用法：R.style.picture.white.style
                .maxSelectNum(maxSelectNum)// 最大图片选择数量
                .minSelectNum(1)// 最小选择数量
                .imageSpanCount(4)// 每行显示个数
                .selectionMode(mode)// 多选 or 单选
                .previewImage(true)// 是否可预览图片
                .isCamera(false)// 是否显示拍照按钮
                .isZoomAnim(true)//图片列表点击 缩放效果 默认true
                //.setOutputCameraPath("/CustomPath")// 自定义拍照保存路径
                .enableCrop(isCrop)// 是否裁剪
                .compress(true)// 是否压缩
                .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .isGif(true)// 是否显示gif图片
                .freeStyleCropEnabled(false)// 裁剪框是否可拖拽
                .circleDimmedLayer(isHead)// 是否圆形裁剪
                .showCropFrame(!isHead)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
                .showCropGrid(!isHead)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
                .selectionMedia(selectList)//是否传入已选图片
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }

    /***
     * 拍照单选配置
     * **/
    public static void initCameraPic(final Activity context, boolean isHead) {
        PictureSelector.create(context)
                .openCamera(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .theme(R.style.picture_default_style)// 主题样式设置 具体参考 values/styles   用法：R.style.picture.white.style
                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选
                //.setOutputCameraPath("/CustomPath")// 自定义拍照保存路径
                .enableCrop(true)// 是否裁剪
                .compress(true)// 是否压缩
                .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .isGif(true)// 是否显示gif图片
                .freeStyleCropEnabled(false)// 裁剪框是否可拖拽
                .circleDimmedLayer(isHead)// 是否圆形裁剪
                .showCropFrame(!isHead)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
                .showCropGrid(!isHead)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code

    }

    public static void initMoreAndSinglePic(final Activity context, final int maxSelectNum, final List<LocalMedia> selectList) {
        initMoreAndSinglePic(context, maxSelectNum, selectList, false);
    }

    /***
     * 单选多选配置
     * **/
    public static void initMoreAndSinglePic(final Activity context, final int maxSelectNum, final List<LocalMedia> selectList, final boolean isCrop) {
        int mode;
        if (maxSelectNum == 1) {
            mode = PictureConfig.SINGLE;
        } else {
            mode = PictureConfig.MULTIPLE;
        }
        PictureSelector.create(context)
                .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .theme(R.style.picture_default_style)// 主题样式设置 具体参考 values/styles   用法：R.style.picture.white.style
                .maxSelectNum(maxSelectNum)// 最大图片选择数量
                .minSelectNum(1)// 最小选择数量
                .imageSpanCount(4)// 每行显示个数
                .selectionMode(mode)// 多选 or 单选
                .previewImage(true)// 是否可预览图片
                .isCamera(true)// 是否显示拍照按钮
                .isZoomAnim(true)//图片列表点击 缩放效果 默认true
                //.setOutputCameraPath("/CustomPath")// 自定义拍照保存路径
                .enableCrop(isCrop)// 是否裁剪
                .compress(true)// 是否压缩
                .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .isGif(true)// 是否显示gif图片
                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽
                .circleDimmedLayer(true)// 是否圆形裁剪
                .showCropFrame(true)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
                .showCropGrid(true)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
                .openClickSound(false)// 是否开启点击声音
                .selectionMedia(selectList)//是否传入已选图片
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }
}
