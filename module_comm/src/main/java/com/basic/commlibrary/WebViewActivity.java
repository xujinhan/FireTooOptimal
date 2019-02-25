package com.basic.commlibrary;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.basic.commlibrary.config.ARoutePaths;
import com.ht.app.base.base.BaseWebActivity;

/**
 * Description: 通用web
 * Author:YanDongDong
 * Data: 2018/5/10.
 */
@Route(path = ARoutePaths.WebAc)
public class WebViewActivity extends BaseWebActivity {
    @Autowired
    String webUrl;
    @Autowired
    String webTitle;

    @Override
    public String getUrl() {
        return webUrl;
    }

    @Override
    public String getWebTitle() {
        return webTitle;
    }

/*    WebView中的shouldOverrideUrlLoading和onPageStarted这两个方法就是可以捕获到跳转的url，然后进行一系列的操作,但是他们两到底有什么区别呢？
    当点击页面中的链接的时候他们俩都会执行，但是返回到上一个页面的时候onPageStarted会执行，但是shouldOverrideUrlLoading就不执行了，就是onPageStarted什么时候都执行的，
    应用场景：有个需求WebView加载不同的url的时候应用的标题也是跟着改变的，这时候只要在onPageStarted中捕获url前缀进行判断就可以了，但是不能使用shouldOverrideUrlLoading，因为当从当前的页面返回到上个页面的时候这个方法并不执行，所以捕获就没有用了！*/
    @Override
    public WebViewClient setWebViewClient() { // return true 表示当前url即使是重定向url也不会再执行   return false  表示由系统执行url，直到不再执行此方法，即加载完重定向的ur（即具体的url，不再有重定向）
        WebViewClient mWebViewClient = new WebViewClient() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request) {
                String url = request.getUrl().toString();
                return  super.shouldOverrideUrlLoading(webView, request);
            }
        };
        return mWebViewClient;
    }
}
