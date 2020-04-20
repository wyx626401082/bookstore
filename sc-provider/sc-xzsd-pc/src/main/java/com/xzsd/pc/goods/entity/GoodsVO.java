package com.xzsd.pc.goods.entity;

import java.util.Date;

/**
 * 商品实体类（传出）
 * @author WangZeBin
 * @date 2020-03-30
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
     * 商品售价
     */
    private String goodsPrice;
    /**
     * 商品成本价（定价）
     */
    private String goodsCost;
    /**
     * 商品图片路径
     */
    private String goodsUrl;
    /**
     * 商品库存
     */
    private String inventory;
    /**
     * 商品销售量
     */
    private int salesNum;
    /**
     * 商家名称
     */
    private String sellerName;
    /**
     * 一级分类编码
     */
    private String classOneId;
    /**
     * 一级分类名称
     */
    private String classOneName;
    /**
     * 二级分类编码
     */
    private String classTwoId;
    /**
     * 二级分类名称
     */
    private String classtwoName;
    /**
     * 书号
     */
    private String bookId;
    /**
     * 作者
     */
    private String author;
    /**
     * 出版社
     */
    private String press;
    /**
     * 广告词
     */
    private String advertise;
    /**
     * 介绍
     */
    private String introduce;
    /**
     * 商品状态（0未发布 1上架 2下架 ）
     */
    private int goodsState;
    /**
     * 上架时间
     */
    private Date putawayTime;
    /**
     * 浏览量
     */
    private String goodsViews;
    /**
     * 评价星级（1~5）
     */
    private int starLevel;
    /**
     * 版本号
     */
    private int version;

    public String getClassOneId() {
        return classOneId;
    }

    public void setClassOneId(String classOneId) {
        this.classOneId = classOneId;
    }

    public String getClassTwoId() {
        return classTwoId;
    }

    public void setClassTwoId(String classTwoId) {
        this.classTwoId = classTwoId;
    }

    public int getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(int goodsState) {
        this.goodsState = goodsState;
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

    public String getGoodsCost() {
        return goodsCost;
    }

    public void setGoodsCost(String goodsCost) {
        this.goodsCost = goodsCost;
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public int getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(int salesNum) {
        this.salesNum = salesNum;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getClassOneName() {
        return classOneName;
    }

    public void setClassOneName(String classOneName) {
        this.classOneName = classOneName;
    }

    public String getClasstwoName() {
        return classtwoName;
    }

    public void setClasstwoName(String classtwoName) {
        this.classtwoName = classtwoName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
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

    public Date getPutawayTime() {
        return putawayTime;
    }

    public void setPutawayTime(Date putawayTime) {
        this.putawayTime = putawayTime;
    }

    public String getGoodsViews() {
        return goodsViews;
    }

    public void setGoodsViews(String goodsViews) {
        this.goodsViews = goodsViews;
    }

    public int getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(int starLevel) {
        this.starLevel = starLevel;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
