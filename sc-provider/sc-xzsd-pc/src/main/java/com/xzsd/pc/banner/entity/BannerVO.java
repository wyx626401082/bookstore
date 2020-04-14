package com.xzsd.pc.banner.entity;

import java.sql.Date;

public class BannerVO {
    /**
     * 轮播图编号
     */
    private String bannerId;
    /**
     * 轮播图图片路径
     */
    private String bannerUrl;
    /**
     * 轮播图排序
     */
    private int bannerNO;
    /**
     * 轮播图状态 0禁用，1启用
     */
    private int bannerState;
    /**
     * 选中的商品编号
     */
    private String goodsId;
    /**
     * 起始时间
     */
    private java.sql.Date startTime;
    /**
     * 终止时间
     */
    private java.sql.Date endTime;
    /**
     * 版本号
     */
    private int version;

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public int getBannerNO() {
        return bannerNO;
    }

    public void setBannerNO(int bannerNO) {
        this.bannerNO = bannerNO;
    }

    public int getBannerState() {
        return bannerState;
    }

    public void setBannerState(int bannerState) {
        this.bannerState = bannerState;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
