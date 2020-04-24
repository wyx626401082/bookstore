package com.xzsd.app.goods.entity;

import java.util.List;

/**
 * 商品评价实体类
 * @author WangZebin
 * @date 2020-04-21
 */
public class EvaluateVO {
    /**
     * 用户账户
     */
    private String userAcct;
    /**
     * 评价表编号
     */
    private String evaluateId;
    /**
     * 评价星级
     */
    private int evaluateStar;
    /**
     * 评价内容
     */
    private String evaluateText;
    /**
     * 评价时间
     */
    private String evaluateTime;
    /**
     * 评价图片信息集合
     */
    private List<ImageInfo> imageList;

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(String evaluateId) {
        this.evaluateId = evaluateId;
    }

    public int getEvaluateStar() {
        return evaluateStar;
    }

    public void setEvaluateStar(int evaluateStar) {
        this.evaluateStar = evaluateStar;
    }

    public String getEvaluateText() {
        return evaluateText;
    }

    public void setEvaluateText(String evaluateText) {
        this.evaluateText = evaluateText;
    }

    public String getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(String evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public List<ImageInfo> getImageList() {
        return imageList;
    }

    public void setImageList(List<ImageInfo> imageList) {
        this.imageList = imageList;
    }
}
