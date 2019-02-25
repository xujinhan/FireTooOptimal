package com.basic.commlibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

import com.basic.commlibrary.config.ARoutePaths;
import com.basic.commlibrary.model.UserInfoModule;
import com.google.gson.Gson;
import com.ht.app.base.config.Constants;
import com.ht.app.base.utils.SPUtils;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ydd on 2018/1/15.
 * 用户信息缓存
 */

public class UserCache extends SPUtils {
    /**
     * 保存用户详情信息
     */
    public static void saveUserInfoDetail(UserInfoModule userInfo) {
        setString(Constants.USERINFOCACHEKEY, new Gson().toJson(userInfo));
    }

    /**
     * 获取用户详情信息
     */
    public static UserInfoModule getUserInfoDetail() {
        String str = getString(Constants.USERINFOCACHEKEY);
        if (!TextUtils.isEmpty(str)) {
            return new Gson().fromJson(str, UserInfoModule.class);
        } else {
            return null;
        }
    }

    /**
     * 清除用户详情数据
     *
     * @return true is success
     */
    public static void clearUserInfoDetail() {
        remove(Constants.USERINFOCACHEKEY);
    }

    public static void loginSuccess(Context context, UserInfoModule userInfoModule, String mPhone) {
        boolean isLoginMain = false;
        String oldPhone = SPUtils.getString(Constants.PHONE);
        if (oldPhone != null && !mPhone.equals(oldPhone)) {
            isLoginMain = true;
        }
        saveUserInfoDetail(userInfoModule);
        SPUtils.setString(Constants.PHONE, mPhone);
        SPUtils.setBoolean(Constants.IS_LOING, true);
        ((Activity) context).finish();
    }


    /**
     * 清除用户数据
     *
     * @return true is success
     */
    public static void clearInviteDetail() {
        remove(Constants.INVITE_DETAIL_KEY);
    }


    /**
     * 清除搜索记录
     * @return true is success
     */
    public static void clearSearchInfo() {
        remove(Constants.HISTORY_LIST);
    }

}
