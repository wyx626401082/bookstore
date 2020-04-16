package com.xzsd.pc.order.entity;

import java.util.Date;

/**
 * 订单管理实体类
 * @author WangZebin
 * @date 2020-04-15
 */
public class OrderVO {
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 订单状态：0订单取消，1订单到货，2取消到货，3订单已取货，4取消已取货
     */
    private int orderState;
    /**
     * 订单总价
     */
    private String orderMoney;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品数量
     */
    private String goodsNumber;
    /**
     * 商品售价
     */
    private String goodsPrice;
    /**
     * 商品总价
     */
    private String totalPrice;
    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 下单人编号
     */
    private String userId;
    /**
     * 下单人名称
     */
    private String userName;
    /**
     * 下单人手机号
     */
    private String userPhone;
    /**
     * 确认付款时间（默认下单时间）
     */
    private String payTime;
    /**
     * 版本号
     */
    private int version;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public String getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(String orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
