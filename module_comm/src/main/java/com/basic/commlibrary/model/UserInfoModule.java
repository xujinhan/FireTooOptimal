package com.basic.commlibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Description:个人资料对象
 * Author: xjh
 * Date:18/8/30
 */
public class UserInfoModule implements Parcelable{

    /**
     * id : 2
     * customerNumber : ZYC20181503000000
     * phone : 15637189659
     * nickname : 111
     * customerType : 0
     * avatar : http://image.zhi-you.net/1/90d9d5b6c70345708bdf4e77448e88d9
     * customerRank : 6
     * gender : 1
     * birthday : 2018-11-30
     * homeProvinceName : null
     * homeCityName : null
     * homeDistrictName : null
     * homeAddress : null
     * homeProvinceId : null
     * homeCityId : null
     * homeDistrictId : null
     * hobby : 喝酒/看球/下棋/看电视/其他
     * identify : null
     * job : 商务/采购/贸易
     * jobId : 36
     * hobbyId : [5,2,4,6,7]
     */

    private int id;
    private String customerNumber;
    private String phone;
    private String nickname;
    private String customerType;
    private String avatar;
    private String customerRank;
    private int gender;
    private String birthday;
    private String homeProvinceName;
    private String homeCityName;
    private String homeDistrictName;
    private String homeAddress;
    private String homeProvinceId;
    private String homeCityId;
    private String homeDistrictId;
    private String hobby;
    private String identify;
    private String job;
    private String jobId;
    private List<String> hobbyId;
    private String inviteName;//":"我是33",
    private String invitePhone;//":"15868155533",
    private String inviteNumber;//":"FTC20180815000006"


    protected UserInfoModule(Parcel in) {
        id = in.readInt();
        customerNumber = in.readString();
        phone = in.readString();
        nickname = in.readString();
        customerType = in.readString();
        avatar = in.readString();
        customerRank = in.readString();
        gender = in.readInt();
        birthday = in.readString();
        homeProvinceName = in.readString();
        homeCityName = in.readString();
        homeDistrictName = in.readString();
        homeAddress = in.readString();
        homeProvinceId = in.readString();
        homeCityId = in.readString();
        homeDistrictId = in.readString();
        hobby = in.readString();
        identify = in.readString();
        job = in.readString();
        jobId = in.readString();
        hobbyId = in.createStringArrayList();
        inviteName = in.readString();
        invitePhone = in.readString();
        inviteNumber = in.readString();
    }

    public static final Creator<UserInfoModule> CREATOR = new Creator<UserInfoModule>() {
        @Override
        public UserInfoModule createFromParcel(Parcel in) {
            return new UserInfoModule(in);
        }

        @Override
        public UserInfoModule[] newArray(int size) {
            return new UserInfoModule[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCustomerRank() {
        return customerRank;
    }

    public void setCustomerRank(String customerRank) {
        this.customerRank = customerRank;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHomeProvinceName() {
        return homeProvinceName;
    }

    public void setHomeProvinceName(String homeProvinceName) {
        this.homeProvinceName = homeProvinceName;
    }

    public String getHomeCityName() {
        return homeCityName;
    }

    public void setHomeCityName(String homeCityName) {
        this.homeCityName = homeCityName;
    }

    public String getHomeDistrictName() {
        return homeDistrictName;
    }

    public void setHomeDistrictName(String homeDistrictName) {
        this.homeDistrictName = homeDistrictName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomeProvinceId() {
        return homeProvinceId;
    }

    public void setHomeProvinceId(String homeProvinceId) {
        this.homeProvinceId = homeProvinceId;
    }

    public String getHomeCityId() {
        return homeCityId;
    }

    public void setHomeCityId(String homeCityId) {
        this.homeCityId = homeCityId;
    }

    public String getHomeDistrictId() {
        return homeDistrictId;
    }

    public void setHomeDistrictId(String homeDistrictId) {
        this.homeDistrictId = homeDistrictId;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public List<String> getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(List<String> hobbyId) {
        this.hobbyId = hobbyId;
    }

    public String getInviteName() {
        return inviteName;
    }

    public void setInviteName(String inviteName) {
        this.inviteName = inviteName;
    }

    public String getInvitePhone() {
        return invitePhone;
    }

    public void setInvitePhone(String invitePhone) {
        this.invitePhone = invitePhone;
    }

    public String getInviteNumber() {
        return inviteNumber;
    }

    public void setInviteNumber(String inviteNumber) {
        this.inviteNumber = inviteNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(customerNumber);
        parcel.writeString(phone);
        parcel.writeString(nickname);
        parcel.writeString(customerType);
        parcel.writeString(avatar);
        parcel.writeString(customerRank);
        parcel.writeInt(gender);
        parcel.writeString(birthday);
        parcel.writeString(homeProvinceName);
        parcel.writeString(homeCityName);
        parcel.writeString(homeDistrictName);
        parcel.writeString(homeAddress);
        parcel.writeString(homeProvinceId);
        parcel.writeString(homeCityId);
        parcel.writeString(homeDistrictId);
        parcel.writeString(hobby);
        parcel.writeString(identify);
        parcel.writeString(job);
        parcel.writeString(jobId);
        parcel.writeStringList(hobbyId);
        parcel.writeString(inviteName);
        parcel.writeString(invitePhone);
        parcel.writeString(inviteNumber);
    }
}
