package com.xzsd.app.goods.entity;

import java.util.List;

/**
 * 商品分类实体类
 * @author WangZebin
 * @date 2020-04-21
 */
public class ClassifyVO {
    /**
     * 一级分类编号
     */
    private String classOneId;
    /**
     * 一级分类名称
     */
    private String classOneName;
    /**
     * 二级分类编号
     */
    private String classTwoId;
    /**
     * 二级分类名称
     */
    private String classTwoName;
    /**
     * 二级分类下商品集合
     */
    private List<GoodsVO> goodsList;

    public String getClassOneId() {
        return classOneId;
    }

    public void setClassOneId(String classOneId) {
        this.classOneId = classOneId;
    }

    public String getClassOneName() {
        return classOneName;
    }

    public void setClassOneName(String classOneName) {
        this.classOneName = classOneName;
    }

    public String getClassTwoId() {
        return classTwoId;
    }

    public void setClassTwoId(String classTwoId) {
        this.classTwoId = classTwoId;
    }

    public String getClassTwoName() {
        return classTwoName;
    }

    public void setClassTwoName(String classTwoName) {
        this.classTwoName = classTwoName;
    }

    public List<GoodsVO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsVO> goodsList) {
        this.goodsList = goodsList;
    }
}
