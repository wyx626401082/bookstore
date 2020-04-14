package com.xzsd.pc.banner.entity;

import java.util.Date;

/**
 * 轮播图实体类
 * @author WangZeBin
 * @date 2020-04-14
 */
public class BannerDO {
    /**
     *页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
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
     * 商品名称
     */
    private String goodsName;
    /**
     * 起始时间
     */
    private java.sql.Date startTime;
    /**
     * 终止时间
     */
    private java.sql.Date endTime;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新时间
     */
    private Date modifyTime;
    /**
     * 更新者
     */
    private String ModifyBy;
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public java.sql.Date getStartTime() {
        return startTime;
    }

    public void setStartTime(java.sql.Date startTime) {
        this.startTime = startTime;
    }

    public java.sql.Date getEndTime() {
        return endTime;
    }

    public void setEndTime(java.sql.Date endTime) {
        this.endTime = endTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(String modifyBy) {
        ModifyBy = modifyBy;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
