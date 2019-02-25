package com.basic.commlibrary;

import android.text.TextUtils;

import com.allen.library.RxHttpUtils;
import com.allen.library.config.OkHttpConfig;
import com.allen.library.cookie.store.SPCookieStore;
import com.basic.commlibrary.config.AppConfig;
import com.basic.commlibrary.config.AppConstants;
import com.basic.commlibrary.interceptor.HttpInterceptor;
import com.ht.app.base.base.BaseApplication;
import com.ht.app.base.utils.FileUtil;
import com.ht.app.base.utils.MD5Utils;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Description:
 * Author: xjh
 * Date:18/12/19
 */
public class CommApplication extends BaseApplication {

    public static IWXAPI api;// IWXAPI 是第三方app和微信通信的openapi接口


    @Override
    protected void initData() {

        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        api = WXAPIFactory.createWXAPI(this, AppConfig.APP_ID, true);
        //将应用appid注册到微信
        api.registerApp(AppConfig.APP_ID);

        initHttp();

    }

    /**
     * 初始化网络请求
     */
    private void initHttp() {
        Map<String, Object> headerMaps = new HashMap<>();
        headerMaps.put("platform", "android");    //header不支持中文，不允许有特殊字符

        OkHttpClient okHttpClient = new OkHttpConfig
                .Builder(this)
                //全局的请求头信息
                .setHeaders(headerMaps)
                //开启缓存策略(默认false)
                //1、在有网络的时候，先去读缓存，缓存时间到了，再去访问网络获取数据；
                //2、在没有网络的时候，去读缓存中的数据。
                .setCache(true)
                //全局持久话cookie,保存到内存（new MemoryCookieStore()）或者保存到本地（new SPCookieStore(this)）
                //不设置的话，默认不对cookie做处理
                .setCookieType(new SPCookieStore(this))
                //可以添加自己的拦截器(比如使用自己熟悉三方的缓存库等等)
                //.setAddInterceptor(null)
                .setAddInterceptor(new HttpInterceptor())//拦截加密
                //全局ssl证书认证
                //1、信任所有证书,不安全有风险（默认信任所有证书）
                //.setSslSocketFactory()
                //2、使用预埋证书，校验服务端证书（自签名证书）
                //.setSslSocketFactory(cerInputStream)
                //3、使用bks证书和密码管理客户端证书（双向认证），使用预埋证书，校验服务端证书（自签名证书）
                //.setSslSocketFactory(bksInputStream,"123456",cerInputStream)
                //全局超时配置
                .setReadTimeout(10)
                //全局超时配置
                .setWriteTimeout(10)
                //全局超时配置
                .setConnectTimeout(10)
                //全局是否打开请求log日志
                .setDebug(true)
                .build();

        RxHttpUtils
                .getInstance()
                .init(this)
                .config()
                //自定义factory的用法
                //.setCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //.setConverterFactory(ScalarsConverterFactory.create(),GsonConverterFactory.create(GsonAdapter.buildGson()))
                //配置全局baseUrl
//                .setBaseUrl("https://api.douban.com/")
                .setBaseUrl(AppConfig.BASE_URL)
                //开启全局配置
                .setOkClient(okHttpClient);
    }

}
