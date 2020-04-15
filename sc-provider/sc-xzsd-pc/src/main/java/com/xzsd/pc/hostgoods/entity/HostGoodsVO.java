package com.xzsd.pc.hostgoods.entity;

public class HostGoodsVO {
    /**
     * 热门商品编号
     */
    private String hostGoodsId;
    /**
     * 热门商品排序
     */
    private int hostGoodsNO;
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
     * 商品介绍
     */
    private String introduce;
    /**
     * 展示数量
     */
    private int showNumber;
    /**
     * 版本号
     */
    private int version;

    public String getHostGoodsId() {
        return hostGoodsId;
    }

    public void setHostGoodsId(String hostGoodsId) {
        this.hostGoodsId = hostGoodsId;
    }

    public int getHostGoodsNO() {
        return hostGoodsNO;
    }

    public void setHostGoodsNO(int hostGoodsNO) {
        this.hostGoodsNO = hostGoodsNO;
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getShowNumber() {
        return showNumber;
    }

    public void setShowNumber(int showNumber) {
        this.showNumber = showNumber;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
