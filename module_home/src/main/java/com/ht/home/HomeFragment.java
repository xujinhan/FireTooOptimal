package com.ht.home;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ht.home.R;
import com.ht.app.base.base.BaseFragment;

/**
 * Description:
 * Author: xjh
 * Date:18/12/19
 */
public class HomeFragment extends BaseFragment {

    private TextView tvToTwo;


    @Override
    protected int getLayoutId() {
        return R.layout.frag_home;
    }

    @Override
    protected void initView(View root) {

        tvToTwo = (TextView) mRootView.findViewById(R.id.tv_to_two);

        tvToTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                GoPath(ARoutePaths.TwoAc);
                ARouter.getInstance().build("/user/login").navigation();
            }
        });

    }
}
