package com.xzsd.pc.order.entity;

import java.util.Date;

/**
 * 订单管理实体类（传入）
 * @author WangZebin
 * @date 2020-04-15
 */
public class OrderDO {
    /**
     *页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 店长编号
     */
    private String managerId;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 订单状态：0订单取消，1订单到货，2取消到货，3订单已取货，4取消已取货
     */
    private int orderState;
    /**
     * 当前登录用户角色
     */
    private int role;
    /**
     * 下单人名称
     */
    private String userName;
    /**
     * 下单人手机号
     */
    private String userPhone;
    /**
     * 支付时间始
     */
    private String payTimeStart;
    /**
     * 支付时间终
     */
    private String payTimeEnd;
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

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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

    public String getPayTimeStart() {
        return payTimeStart;
    }

    public void setPayTimeStart(String payTimeStart) {
        this.payTimeStart = payTimeStart;
    }

    public String getPayTimeEnd() {
        return payTimeEnd;
    }

    public void setPayTimeEnd(String payTimeEnd) {
        this.payTimeEnd = payTimeEnd;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
