package com.basic.commlibrary.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.basic.commlibrary.config.ARoutePaths;
import com.ht.app.base.config.Constants;
import com.ht.app.base.utils.SPUtils;

/**
 * Description:登录拦截器
 * Author:YanDongDong
 * Data: 2018/6/7.
 */
@Interceptor(priority = 1)
public class LoginInterceptor implements IInterceptor {
    /**
     * The operation of this interceptor.
     */
    @Override
    public void process(final Postcard postcard, final InterceptorCallback callback) {
        String path = postcard.getPath();

        switch (path) {
            case ARoutePaths.WebAc:
                callback.onContinue(postcard);
                break;
            default:
                if (!SPUtils.getBoolean(Constants.IS_LOING)) {//没有登录
                    callback.onInterrupt(null);
//                    MyUtils.GoPath(ARoutePaths.LoginCodeAccountAc); //TODO  添加login页面
                } else {
                    callback.onContinue(postcard);
                }
                break;

        }
    }


    /**
     * Do your init work in this method, it well be call when processor has been load.
     */
    @Override
    public void init(Context context) {
    }
}
