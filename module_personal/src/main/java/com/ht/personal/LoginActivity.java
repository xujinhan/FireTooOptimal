package com.ht.personal;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ht.app.base.base.BaseActivity;

/**
 * Description:
 * Author: ydd
 * Date:2018/11/27
 */
@Route(path = "/user/login")
public class LoginActivity extends BaseActivity {

    @Override
    protected int getContentView() {
        return R.layout.frag_personal;
    }

    @Override
    protected void initView() {
    }
}
