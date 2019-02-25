package com.basic.commlibrary.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

import com.basic.commlibrary.R;
import com.ht.app.base.utils.BitmapUtil;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;

import java.io.File;
import java.net.URL;

import static com.basic.commlibrary.CommApplication.api;

/**
 * Description: 分享的工具类
 * Author: xjh
 * Date:18/9/12
 */
public class ShareUtils {

    private static final int THUMB_SIZE = 150;
    private static int mTargetScene = SendMessageToWX.Req.WXSceneSession; //发送到聊天界面
    private static int mTimeline = SendMessageToWX.Req.WXSceneTimeline; //发送到朋友圈

    public static void loginFromWX() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "ht_login_wechat";
        api.sendReq(req);
    }

    /**
     * 发送微信
     * type :0送到聊天界面，否则发送到朋友圈
     */
    public static void sendWxWeb(final Context context, final String title, final String content, final String imageUrl, final String loadaUrl, final int type) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    WXWebpageObject webpage = new WXWebpageObject();
                    webpage.webpageUrl = loadaUrl;
                    WXMediaMessage msg = new WXMediaMessage(webpage);
                    msg.title = title;
                    msg.description = content;
                    Bitmap bmp ;
                    if(TextUtils.isEmpty(imageUrl)){
                        bmp = BitmapFactory.decodeResource(context.getResources(), R.mipmap.default_launcher);
                    }else {
                        bmp = BitmapFactory.decodeStream(new URL(imageUrl).openStream());
                    }
                    Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE, THUMB_SIZE, true);
                    bmp.recycle();
                    msg.thumbData = BitmapUtil.bmpToByteArray(thumbBmp, true);

                    SendMessageToWX.Req req = new SendMessageToWX.Req();
                    req.transaction =
                            ("webpage");//字段用于唯一标识的一个请求
                    req.message = msg;
                    if (type == 0) {//发送到聊天界面
                        req.scene = mTargetScene;
                    } else {//发送到朋友圈
                        req.scene = mTimeline;
                    }
                    api.sendReq(req);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }

    /**
     * 发送图片二进制
     * 0是微信好友 1是朋友圈
     */
    public static void shareBitmap(Bitmap bmp, int type) {
        WXImageObject imgObj = new WXImageObject(bmp);

        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = imgObj;

        Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE, THUMB_SIZE, true);
        bmp.recycle();
        msg.thumbData = BitmapUtil.bmpToByteArray(thumbBmp, true);

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("img");
        req.message = msg;
//        req.scene = mTargetScene;
        if (type == 0) {//发送到聊天界面
            req.scene = mTargetScene;
        } else {//发送到朋友圈
            req.scene = mTimeline;
        }
        api.sendReq(req);
    }

    /**
     * 发送图片路径
     */
    public static void shareBitmapByPath(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        WXImageObject imgObj = new WXImageObject();
        imgObj.setImagePath(path);
        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = imgObj;
        Bitmap bmp = BitmapFactory.decodeFile(path);
        Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE, THUMB_SIZE, true);
        bmp.recycle();
        msg.thumbData = BitmapUtil.bmpToByteArray(thumbBmp, true);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("img");
        req.message = msg;
        req.scene = mTargetScene;
        api.sendReq(req);
    }

}
