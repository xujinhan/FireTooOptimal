package com.ht.app.base.config;

/**
 * Description:一些常量
 * Author: 闫东东
 * Date:18/6/13
 */

public class Constants {
    /**
     * 图片的集合
     **/
    public static final String P_PICS = "PICS";
    /**
     * 传递过去的index
     **/
    public static final String P_INDEX = "P_INDEX";
    /**
     * 登陆标示
     */
    public static final String IS_LOING = "IS_LOGIN";
    /**
     * 存放用户到缓存的标识
     **/
    public static final String USERCACHEKEY = "USERDETAIL";
    /**
     * 存放用户邀请人的标识
     **/
    public static final String INVITE_DETAIL_KEY = "INVITEDETAIL";
    /**
     * 存放用户详情到缓存的标识
     **/
    public static final String USERINFOCACHEKEY = "USERINFODETAIL";
    /**
     * TOKNE
     */
    public static final String TOKEN = "TOKEN";
    /**
     * 网络请求的限制时间
     */
    public static final int REQ_TIMEOUT = 5000;
    /**
     * 获取列表的条数
     */
    public static final int PAGE_SIZE10 = 10;//请求条数

    /**
     * token过期跳登录页面的code
     */
    public static final int RESULT_LOGIN = 10000;
    /**
     * 搜索的历史记录
     **/
    public static final String HISTORY_LIST = "history_detail";

    /**
     * 登录的手机号
     **/
    public static final String PHONE = "PHONE";
}
