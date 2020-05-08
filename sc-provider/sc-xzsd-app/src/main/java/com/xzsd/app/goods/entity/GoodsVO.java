package com.xzsd.app.goods.entity;

/**
 * 商品详情实体类
 * @author WangZebin
 * @date 2020-04-21
 */
public class GoodsVO {
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 书号
     */
    private String bookId;
    /**
     * 商品图片路径
     */
    private String goodsUrl;
    /**
     * 在售价
     */
    private String goodsPrice;
    /**
     * 商品库存
     */
    private String inventory;
    /**
     * 商品星级评分
     */
    private String starLevel;
    /**
     * 商品销售量
     */
    private String goodsSales;
    /**
     * 商品浏览量
     */
    private String goodsViews;
    /**
     * 广告词
     */
    private String advertise;
    /**
     * 介绍
     */
    private String introduce;
    /**
     * 作者
     */
    private String author;
    /**
     * 出版社
     */
    private String press;

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

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getGoodsSales() {
        return goodsSales;
    }

    public void setGoodsSales(String goodsSales) {
        this.goodsSales = goodsSales;
    }

    public String getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(String starLevel) {
        this.starLevel = starLevel;
    }

    public String getGoodsViews() {
        return goodsViews;
    }

    public void setGoodsViews(String goodsViews) {
        this.goodsViews = goodsViews;
    }

    public String getAdvertise() {
        return advertise;
    }

    public void setAdvertise(String advertise) {
        this.advertise = advertise;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }
}
