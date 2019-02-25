package com.ht.app.base.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ht.app.base.weight.MyTitleView;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;
import org.greenrobot.eventbus.EventBus;
/**
 * Description:baseFragment封装
 * Author: 闫东东
 * Date:18/6/13
 */
public abstract class BaseFragment extends Fragment implements  View.OnClickListener , SuperRecyclerView.LoadingListener{
    public Toast mToast;
    public View mRootView;
    protected Bundle mBundle;
    protected LayoutInflater mInflater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle = getArguments();
        initBundle(mBundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null)
                parent.removeView(mRootView);
        } else {
            mRootView = inflater.inflate(getLayoutId(), container, false);
            mInflater = inflater;
            ARouter.getInstance().inject(this);
            // Do something
            onBindViewBefore(mRootView);
            // Bind view
            // Get savedInstanceState
            if (savedInstanceState != null)
                onRestartInstance(savedInstanceState);
            // Init
            initView(mRootView);
            initData();
        }
        return mRootView;
    }

    protected void initBundle(Bundle bundle) {
    }

    protected abstract int getLayoutId();

    protected void onBindViewBefore(View root) {
    }

    protected abstract void initView(View root);

    protected void initData() {
    }

    protected void onRestartInstance(Bundle bundle) {
    }

    @Override
    public void onStop() {
        if (mToast != null) {
            mToast.cancel();
        }
        super.onStop();
    }
    public void initTitleView(MyTitleView titleView, int titel) {
        titleView.getCenterView().setText(titel);
        titleView.getLeftView().setVisibility(View.GONE);
    }
    //进行跳转
    public void GoPath(String path) {
        GoPath(path, null);
    }

    public void GoPath(String path, Bundle bundle) {
        ARouter.getInstance().build(path).with(bundle).navigation();
    }

    public void showToast(String msg) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(getActivity(), msg , Toast.LENGTH_SHORT);
        mToast.show();
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
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault() != null) {
            EventBus.getDefault().unregister(this);//反注册EventBus
        }
        mBundle = null;
    }
}
