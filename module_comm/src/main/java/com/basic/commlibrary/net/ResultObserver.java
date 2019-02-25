package com.basic.commlibrary.net;

import com.allen.library.base.BaseObserver;
import com.basic.commlibrary.model.BaseResponse;

import io.reactivex.disposables.Disposable;

/**
 * Description:
 * Author: xjh
 * Date:18/12/18
 */
public abstract class ResultObserver<T> extends BaseObserver<BaseResponse<T>> {
    @Override
    public void doOnSubscribe(Disposable d) {

    }

    @Override
    public void doOnError(String errorMsg) {
        BaseResponse a = new BaseResponse<T>();
        a.msg = errorMsg;
        onFail(a);
    }

    @Override
    public void doOnNext(BaseResponse<T> tBaseResponse) {
        onSuc(tBaseResponse);
    }

    @Override
    public void doOnCompleted() {

    }

    public abstract void onSuc(BaseResponse<T> response);

    public void onFail(BaseResponse<T> error) {

    }


}
