package com.xzsd.app.manager.entity;

public class UserInfo {
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 门店邀请码
     */
    private String inviteCode;
    /**
     * 门店详细地址(省市区+详细地址)
     */
    private String storeAddress;
    /**
     * 司机名称
     */
    private String driverName;
    /**
     * 司机电话号码
     */
    private String driverPhone;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }
}
