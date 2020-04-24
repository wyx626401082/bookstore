package com.xzsd.app.customer.entity;

/**
 * 客户信息管理实体类（传出）
 * @author WangZeBin
 * @date 2020-04-20
 */
public class CustomerVO {
    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 门店名称
     */
    private String storeName;

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
}
