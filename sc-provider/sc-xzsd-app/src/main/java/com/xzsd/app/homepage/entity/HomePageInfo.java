package com.xzsd.app.homepage.entity;

/**
 * 客户端首页展示实体类
 * @author WangZeBin
 * @date 2020-04-20
 */
public class HomePageInfo {
    /**
     * 轮播图编号
     */
    private String bannerId;
    /**
     * 轮播图图片路径
     */
    private String bannerUrl;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品价格
     */
    private String goodsPrice;
    /**
     * 商品图片路径
     */
    private String goodsUrl;
    /**
     * 热门商品编号
     */
    private String hostGoodsId;

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

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    public String getHostGoodsId() {
        return hostGoodsId;
    }

    public void setHostGoodsId(String hostGoodsId) {
        this.hostGoodsId = hostGoodsId;
    }
}
