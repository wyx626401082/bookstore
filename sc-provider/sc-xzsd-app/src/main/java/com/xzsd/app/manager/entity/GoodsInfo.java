package com.xzsd.app.manager.entity;

/**
 * 商品信息实体类
 * @author WangZeBin
 * @date 2020-04-24
 */
public class GoodsInfo {
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 商品价格
     */
    private String goodsPrice;
    /**
     * 商品数量
     */
    private int goodsNumber;
    /**
     * 商品图片路径
     */
    private String goodsUrl;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }
}
