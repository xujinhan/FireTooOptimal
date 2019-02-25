package com.basic.commlibrary.net;

import com.basic.commlibrary.model.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Description:
 * Author: xjh
 * Date:18/12/18
 */
public interface ApiService {

    //登录
    @FormUrlEncoded
    @POST("customerLogin/loginByPassword")
    Observable<BaseResponse<Object>> login(@Field("phone") String mobile, @Field("password")
            String password);

}
