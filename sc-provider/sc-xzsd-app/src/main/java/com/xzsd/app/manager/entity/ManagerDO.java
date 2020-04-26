package com.xzsd.app.manager.entity;

/**
 * 店长端管理实体类（传入）
 * @author WangZeBin
 * @date 2020-04-24
 */
public class ManagerDO {
    /**
     *页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 订单状态
     */
    private String orderState;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 版本号
     */
    private int version;


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
