package com.xzsd.pc.goods.entity;

/**
 * 商品分类实体类
 * @author WangZeBin
 * @date 2020-03-30
 */
public class ClassifyVO {
    /**
     * 分类编号
     */
    String classifyId;
    /**
     * 分类名称
     */
    String classifyName;

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }
}
