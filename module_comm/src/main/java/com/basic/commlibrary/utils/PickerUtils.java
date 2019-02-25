package com.basic.commlibrary.utils;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.basic.commlibrary.imp.OnCustomListener;
import com.basic.commlibrary.model.LogisticsNameModule;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.ht.app.base.base.BaseActivity;
import com.ht.app.base.utils.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description:仿ios滚轮
 * Author: ydd
 * Date:2018/8/30
 */
public class PickerUtils {

    /**
     * 年月日
     *
     * @param context
     * @param textView
     */
    public static void initYMDPicker(final BaseActivity context, final TextView textView) {

        //时间选择器
        TimePickerView pvTime = new TimePickerBuilder(context, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
//                        Toast.makeText(MainActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
                textView.setText(DateUtil.dateToString(date, DateUtil.DatePattern.ONLY_DAY));
            }
        })
                .setType(new boolean[]{true, true, true, true, true, true})// 默认全部显示
                .setCancelText("Cancel")//取消按钮文字
                .setSubmitText("Sure")//确认按钮文字
//                .setContentSize(18)//滚轮文字大小
                .setTitleSize(20)//标题文字大小
                .setTitleText("Title")//标题文字
                .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(true)//是否循环滚动
                .setTitleColor(Color.BLACK)//标题文字颜色
                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                .setCancelColor(Color.BLUE)//取消按钮文字颜色
                .setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
                .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
//                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
//                .setRangDate(startDate, endDate)//起始终止年月日设定
//                .setLabel("年", "月", "日", "时", "分", "秒")//默认设置为年月日时分秒
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(true)//是否显示为对话框样式
                .build();

        pvTime.show();

    }

    public static void onOptionPicker(Activity context, List<LogisticsNameModule> list,
                                      int selectNumber, final OnCustomListener listener) {
        ArrayList<String> namelist = new ArrayList<>();
        for (LogisticsNameModule nameModule : list) {
            namelist.add(MyUtils.isEmpty(nameModule.getLogisticsName()));
        }

        //条件选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3 ,View v) {
                //返回的分别是三个级别的选中位置
                if (listener != null) {
                    listener.onCustomerListener(null, options1);
                }
            }
        }).build();
        pvOptions.setPicker(namelist);
        pvOptions.show();


    }


}
