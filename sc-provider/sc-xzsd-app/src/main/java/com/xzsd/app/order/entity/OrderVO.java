package com.xzsd.app.order.entity;

import java.util.List;

/**
 * 订单实体类（传出）
 * @author WangZeBin
 * @date 2020-04-22
 */
public class OrderVO {
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 订单状态
     */
    private String orderState;
    /**
     * 订单总价
     */
    private String orderMoney;
    /**
     * 订单商品总数量
     */
    private int orderAllNum;
    /**
     * 订单创建时间
     */
    private String createTime;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 门店地址
     */
    private String storeAddress;
    /**
     * 版本号
     */
    private int version;
    /**
     * 商品信息集合
     */
    private List<GoodsInfo> goodsList;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(String orderMoney) {
        this.orderMoney = orderMoney;
    }

    public int getOrderAllNum() {
        return orderAllNum;
    }

    public void setOrderAllNum(int orderAllNum) {
        this.orderAllNum = orderAllNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<GoodsInfo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsInfo> goodsList) {
        this.goodsList = goodsList;
    }
}
