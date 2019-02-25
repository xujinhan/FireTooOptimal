package com.ht.app.base.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ht.app.base.config.AppConfig;
import com.ht.app.base.utils.AppUtil;
import com.ht.app.base.utils.ContextUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/20.
 */

public abstract class BaseApplication extends Application {
    private static BaseApplication application;
    Map<String, Object> headerMaps = new HashMap<>();

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        ContextUtil.setmCtx(this);
        initRoute();
        initHttp();
        initData();
    }

    private void initRoute() {
        if (AppConfig.IS_DEBUG) {          // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }

    private void initHttp() {
        headerMaps.put("_platform", "android");
        headerMaps.put("_version", AppUtil.getVersionCode());
    }

    public static BaseApplication getApplication() {
        return application;
    }

    protected void initData() {

    }

}
