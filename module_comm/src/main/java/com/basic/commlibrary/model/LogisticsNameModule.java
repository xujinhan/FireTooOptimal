package com.basic.commlibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Description：物流公司名称
 * Author: xjh
 * Date:18/11/14
 */
public class LogisticsNameModule implements Parcelable{


    /**
     * logisticsName : 京东
     * logisticsSn : JD
     * time : null
     */

    private String logisticsName;
    private String logisticsSn;
    private String time;

    protected LogisticsNameModule(Parcel in) {
        logisticsName = in.readString();
        logisticsSn = in.readString();
        time = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(logisticsName);
        dest.writeString(logisticsSn);
        dest.writeString(time);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LogisticsNameModule> CREATOR = new Creator<LogisticsNameModule>() {
        @Override
        public LogisticsNameModule createFromParcel(Parcel in) {
            return new LogisticsNameModule(in);
        }

        @Override
        public LogisticsNameModule[] newArray(int size) {
            return new LogisticsNameModule[size];
        }
    };

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public String getLogisticsSn() {
        return logisticsSn;
    }

    public void setLogisticsSn(String logisticsSn) {
        this.logisticsSn = logisticsSn;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
