package com.xzsd.app.order.entity;

import java.util.List;

/**
 * 商品评价实体类（传入）
 * @author WangZeBin
 * @date 2020-04-23
 */
public class EvaluateDO {
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 评价信息集合
     */
    private List<EvaluateInfo> evaluateList;

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

    public List<EvaluateInfo> getEvaluateList() {
        return evaluateList;
    }

    public void setEvaluateList(List<EvaluateInfo> evaluateList) {
        this.evaluateList = evaluateList;
    }
}
