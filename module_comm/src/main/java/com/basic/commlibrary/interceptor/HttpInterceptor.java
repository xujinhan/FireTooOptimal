package com.basic.commlibrary.interceptor;

import android.text.TextUtils;

import com.ht.app.base.utils.MD5Utils;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Description:网络请求拦截器
 * Author: xjh
 * Date:18/12/24
 */
public class HttpInterceptor implements Interceptor {

    private static final String[] fields = {"payPassword", "oldPassword", "password",
            "oldPayPassword"};

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        //请求定制：添加请求头
        Request.Builder requestBuilder = original.newBuilder();

        //请求体定制：统一添加token参数
        if (original.body() instanceof FormBody) {
            FormBody.Builder newFormBody = new FormBody.Builder();
            FormBody oidFormBody = (FormBody) original.body();
            String paramsStr = "";
            for (int i = 0; i < oidFormBody.size(); i++) {
                String key = oidFormBody.encodedName(i);
                String valye = oidFormBody.encodedValue(i);

                //部分字段加密
                for (String field : fields) {
                    if (!TextUtils.isEmpty(valye) && field.equals(key)) {
                        valye = MD5Utils.EncoderByMd5(valye);
                    }
                }
                paramsStr += key + "=" + valye + "&";
                newFormBody.addEncoded(key, valye);
            }
            newFormBody.add("token", "");//TODO xjh 添加token
            paramsStr += "token=" + "";//TODO xjh 添加token
            String sign = MD5Utils.EncoderByMd5(MD5Utils.EncoderByMd5(paramsStr));
            newFormBody.add("sign", sign);

            requestBuilder.method(original.method(), newFormBody.build());
        }
        Request requests = requestBuilder.build();

        return chain.proceed(requests);
    }
}
