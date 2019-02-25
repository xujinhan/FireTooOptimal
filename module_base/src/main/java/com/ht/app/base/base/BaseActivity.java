package com.ht.app.base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.github.zackratos.ultimatebar.UltimateBar;
import com.ht.app.base.manager.ActivityManager;

import org.greenrobot.eventbus.EventBus;

import com.ht.app.base.R;
import com.ht.app.base.weight.MyTitleView;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;

/**
 * Description:baseActivity封装
 * Author: 闫东东
 * Date:18/6/13
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener, SuperRecyclerView.LoadingListener {
    private Toast mToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getActivityManager().add(this);
        ARouter.getInstance().inject(this);
        if (initBundle(getIntent().getExtras())) {
            setContentView(getContentView());
            initWindow();
            onRestartInstance(savedInstanceState);

            initView();
            initData();
        } else {
            finish();
        }
    }

    protected boolean initBundle(Bundle bundle) {
        return true;
    }

    protected abstract int getContentView();

    protected abstract void initView();

    protected void initData() {

    }

    protected void initWindow() {
        initSystemBar(R.color.select_color);
    }

    public void initSystemBar(int color) {
        UltimateBar.Companion.with(this)
                .create()
                .immersionBar();
    }

    //进行跳转
    public void GoPath(String path) {
        GoPath(path, null);
    }

    public void GoPath(String path, Bundle bundle) {
        ARouter.getInstance().build(path).with(bundle).navigation();
    }

    public void GoPath(String path, int code) {
        GoPath(path, null, code);
    }

    public void GoPath(String path, Bundle bundle, int code) {
        ARouter.getInstance().build(path).with(bundle).navigation(this, code);
    }

    protected void onRestartInstance(Bundle bundle) {
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    public void showToast(String msg) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        mToast.show();
    }

    public void showToast(int msg) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, getString(msg), Toast.LENGTH_SHORT);
        mToast.show();
    }

    public void initTitleView(MyTitleView titleView, int titel) {
        titleView.getCenterView().setText(titel);
        titleView.getLeftView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void initTitleView(MyTitleView titleView, String titel) {
        titleView.getCenterView().setText(titel);
        titleView.getLeftView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault() != null) {
            EventBus.getDefault().unregister(this);//反注册EventBus
        }
        ActivityManager.getActivityManager().remove(this);
    }
}
