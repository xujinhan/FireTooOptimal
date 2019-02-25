package com.basic.commlibrary.utils;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.basic.commlibrary.R;

/**
 * Description:倒计时
 * Author: xjh
 * Date:18/8/6
 */
public class TimerCount extends CountDownTimer {
    private TextView tvGetCode;
    Context mContext;

    public TimerCount(Context context, long millisInFuture, long countDownInterval, TextView bnt) {
        super(millisInFuture, countDownInterval);
        this.tvGetCode = bnt;
        mContext = context;
    }

    //自定义
    public TimerCount(Context context, TextView bnt) {
        super(120 * 1000, 1000);
        this.tvGetCode = bnt;
        mContext = context;
    }

    public TimerCount(Context context, long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        mContext = context;
    }

    @Override
    public void onFinish() {
        tvGetCode.setClickable(true);
        if (this != null) {
            this.cancel();
        }
        if (tvGetCode != null) {
            tvGetCode.setText(R.string.get_verification_code);
            tvGetCode.setTextColor(Color.parseColor("#666666"));
            tvGetCode.setEnabled(true);
        }
    }

    @Override
    public void onTick(long millisUntilFinished) {
        tvGetCode.setClickable(false);
        if (tvGetCode != null) {
            tvGetCode.setTextColor(Color.BLACK);
            tvGetCode.setText(R.string.repeat_after_sixty_seconds);
            tvGetCode.setText(String.format(mContext.getString(R.string.repeat_after_sixty_seconds), millisUntilFinished / 1000));
        }
    }
}