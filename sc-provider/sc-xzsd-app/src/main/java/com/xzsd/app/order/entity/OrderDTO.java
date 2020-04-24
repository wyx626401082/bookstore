package com.xzsd.app.order.entity;

/**
 * 订单实体类（数据传输）
 * @author WangZeBin
 * @date 2020-04-22
 */
public class OrderDTO {
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 订单总价
     */
    private String orderMoney;
    /**
     * 订单明细表编号
     */
    private String orderDetailId;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 商品数量
     */
    private int goodsNumber;
    /**
     * 商品价格
     */
    private String goodsPrice;
    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 购物车编号
     */
    private String shoppingCartId;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;

    /**
     * 实体类构造方法
     * @param userId
     * @param orderId
     * @param orderDetailId
     * @param goodsId
     * @param goodsNumber
     * @param goodsPrice
     * @param storeId
     * @param shoppingCartId
     * @param isDeleted
     */
    public OrderDTO(String userId, String orderId, String orderDetailId, String goodsId, int goodsNumber, String goodsPrice, String storeId, String shoppingCartId, int isDeleted) {
        this.userId = userId;
        this.orderId = orderId;
        this.orderDetailId = orderDetailId;
        this.goodsId = goodsId;
        this.goodsNumber = goodsNumber;
        this.goodsPrice = goodsPrice;
        this.storeId = storeId;
        this.shoppingCartId = shoppingCartId;
        this.isDeleted = isDeleted;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(String orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(String shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
