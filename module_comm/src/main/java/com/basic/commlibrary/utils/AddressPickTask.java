//package com.basic.commlibrary.utils;
//
//import android.app.Activity;
//import android.graphics.Color;
//import android.os.AsyncTask;
//
//import com.basic.commlibrary.R;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//import cn.addapp.pickers.entity.Province;
//import cn.addapp.pickers.picker.AddressPicker;
//import cn.addapp.pickers.util.ConvertUtils;
//
//
///**
// * 获取地址数据并显示地址选择器
// *
// * @author matt
// * blog: addapp.cn
// */
//public class AddressPickTask extends AsyncTask<String, Void, ArrayList<Province>> {
//    private Activity activity;
//    //    private ProgressDialog dialog;
//    private Callback callback;
//    private String selectedProvince = "", selectedCity = "", selectedCounty = "";
//    private boolean hideProvince = false;
//    private boolean hideCounty = false;
//
//    public AddressPickTask(Activity activity) {
//        this.activity = activity;
//    }
//
//    public void setHideProvince(boolean hideProvince) {
//        this.hideProvince = hideProvince;
//    }
//
//    public void setHideCounty(boolean hideCounty) {
//        this.hideCounty = hideCounty;
//    }
//
//    public void setCallback(Callback callback) {
//        this.callback = callback;
//    }
//
//    @Override
//    protected void onPreExecute() {
////        dialog = ProgressDialog.show(activity, null, "正在初始化数据...", true, true);
//    }
//
//    @Override
//    protected ArrayList<Province> doInBackground(String... params) {
//        if (params != null) {
//            switch (params.length) {
//                case 1:
//                    selectedProvince = params[0];
//                    break;
//                case 2:
//                    selectedProvince = params[0];
//                    selectedCity = params[1];
//                    break;
//                case 3:
//                    selectedProvince = params[0];
//                    selectedCity = params[1];
//                    selectedCounty = params[2];
//                    break;
//                default:
//                    break;
//            }
//        }
//        ArrayList<Province> data = new ArrayList<>();
//        try {
//            String json = ConvertUtils.toString(activity.getAssets().open("city.json"));
//            Gson gson = new Gson();
//            data.addAll((Collection<? extends Province>) gson.fromJson(json, new TypeToken<ArrayList<Province>>() {
//            }.getType()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return data;
//    }
//
//    @Override
//    protected void onPostExecute(ArrayList<Province> result) {
////        dialog.dismiss();
//        if (result.size() > 0) {
//            AddressPicker picker = new AddressPicker(activity, result);
//            picker.setCanLoop(false);
//            picker.setHideProvince(hideProvince);
//            picker.setHideCounty(hideCounty);
//            picker.setCancelTextColor(activity.getResources().getColor(R.color.t409EFF));
//            picker.setSubmitTextColor(activity.getResources().getColor(R.color.t409EFF));
//            picker.setSelectedTextColor(Color.BLACK);
//            picker.setWheelModeEnable(true);
//            if (hideCounty) {
//                picker.setColumnWeight(1 / 3.0f, 2 / 3.0f);//将屏幕分为3份，省级和地级的比例为1:2
//            } else {
//                picker.setColumnWeight(2 / 8.0f, 3 / 8.0f, 3 / 8.0f);//省级、地级和县级的比例为2:3:3
//            }
//            picker.setSelectedItem(selectedProvince, selectedCity, selectedCounty);
////            picker.setOnLinkageListener(callback);
//            callback.showPicker(picker);
////            picker.show();
//        } else {
//            callback.onAddressInitFailed();
//        }
//    }
//
//    public interface Callback {
//
//        void onAddressInitFailed();
//
//        void showPicker(AddressPicker picker);
//
//    }
//
//}
