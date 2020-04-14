package com.xzsd.pc.banner.entity;

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
     * 商品状态（仅为 1在售 ）
     */
    private int goodsState;
    /**
     * 一级分类名称
     */
    private String classOneName;
    /**
     * 二级分类名称
     */
    private String classTwoName;

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

    public int getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(int goodsState) {
        this.goodsState = goodsState;
    }

    public String getClassOneName() {
        return classOneName;
    }

    public void setClassOneName(String classOneName) {
        this.classOneName = classOneName;
    }

    public String getClassTwoName() {
        return classTwoName;
    }

    public void setClassTwoName(String classTwoName) {
        this.classTwoName = classTwoName;
    }
}
