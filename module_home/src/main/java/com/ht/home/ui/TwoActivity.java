package com.ht.home.ui;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ht.home.R;
import com.ht.app.base.base.BaseActivity;

/**
 * Description:
 * Author: xjh
 * Date:18/12/19
 */
@Route(path = "/home/home")
public class TwoActivity extends BaseActivity{


    @Override
    protected int getContentView() {
        return R.layout.act_two;
    }

    @Override
    protected void initView() {


    }
}
