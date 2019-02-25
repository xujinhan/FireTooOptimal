package com.basic.commlibrary.net;

import com.allen.library.RxHttpUtils;

/**
 * Description:
 * Author: xjh
 * Date:18/12/18
 */
public class ApiImpl {

    public static ApiService getApi() {
        return build(ApiService.class);
    }

    private static <T> T build(Class<T> claz) {
        return RxHttpUtils.createApi(claz);
    }

}
