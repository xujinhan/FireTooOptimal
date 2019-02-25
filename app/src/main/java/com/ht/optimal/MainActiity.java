package com.ht.optimal;

import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.allen.library.interceptor.Transformer;
import com.basic.commlibrary.model.BaseResponse;
import com.basic.commlibrary.net.ApiImpl;
import com.basic.commlibrary.net.ResultObserver;
import com.ht.optimal.R;
import com.ht.app.base.base.BaseActivity;
import com.ht.app.base.utils.UIUtil;

/**
 * Description:
 * Author: xjh
 * Date:18/12/17
 */
public class MainActiity extends BaseActivity {

    private TextView tvStart;
    private FragmentTabHost fthTabhost;

    private static String[] mTextviewArray;
//    public static final Class<?>[] FRAGMENT_ARRAY = {HomeFragment.class, MessageFragment.class, CartFragment.class, PersonalFragment.class};
    private static final int[] mImageViewArray = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    @Override
    protected int getContentView() {
        return R.layout.act_main;
    }

    @Override
    protected void initView() {
//
        tvStart = (TextView) findViewById(R.id.tv_start);
        fthTabhost = (FragmentTabHost) findViewById(R.id.fth_tabhost);

        fthTabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTextviewArray = getResources().getStringArray(R.array.nav_tab_list);
        initTabView();

    }

    private void initTabView() {
//        fthTabhost.clearAllTabs();
//        int length = FRAGMENT_ARRAY.length;
//        for (int i = 0; i < length; i++) {
//            TabHost.TabSpec tabSpec = fthTabhost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
//            fthTabhost.addTab(tabSpec, FRAGMENT_ARRAY[i], null);
//        }
//        fthTabhost.getTabWidget().setDividerDrawable(null);
    }

    private View getTabItemView(int index) {
        View view = getLayoutInflater().inflate(R.layout.main_nav_tab_spec, null);
        ImageView imageView = UIUtil.find(view, R.id.tab_imageview_new);
        imageView.setImageResource(mImageViewArray[index]);
        TextView textView = UIUtil.find(view, R.id.tab_textview_new);
        textView.setText(mTextviewArray[index]);
        return view;
    }

    @Override
    protected void initData() {

        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//post请求

                ApiImpl.getApi().login("15868155530", "123456")
                        .compose(Transformer.<BaseResponse<Object>>switchSchedulers())
                        .subscribe(new ResultObserver<Object>() {
                            @Override
                            public void onSuc(BaseResponse<Object> response) {
                                showToast("成功");
                            }
                        });


            }
        });

    }


}
