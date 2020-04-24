package com.xzsd.app.order.entity;

import java.util.List;

/**
 * 商品评价信息
 * @author WangZeBin
 * @date 2020-04-23
 */
public class EvaluateInfo {
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 评价表编号
     */
    private String evaluateId;
    /**
     * 评价等级
     */
    private String starLevel;
    /**
     * 评价内容
     */
    private String evaluateText;
    /**
     * 评价图片信息集合
     */
    private List<ImageInfo> imageList;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(String evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(String starLevel) {
        this.starLevel = starLevel;
    }

    public String getEvaluateText() {
        return evaluateText;
    }

    public void setEvaluateText(String evaluateText) {
        this.evaluateText = evaluateText;
    }

    public List<ImageInfo> getImageList() {
        return imageList;
    }

    public void setImageList(List<ImageInfo> imageList) {
        this.imageList = imageList;
    }
}
