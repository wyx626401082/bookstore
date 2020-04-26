package com.xzsd.app.driver.entity;

/**
 * 门店信息实体类
 * @author WangZeBin
 * @date 2020-04-24
 */
public class StoreInfo {
    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 门店地址(省市区+详细地址)
     */
    private String storeAddress;
    /**
     * 店长名称
     */
    private String managerName;
    /**
     * 店长电话号码
     */
    private String managerPhone;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }
}
