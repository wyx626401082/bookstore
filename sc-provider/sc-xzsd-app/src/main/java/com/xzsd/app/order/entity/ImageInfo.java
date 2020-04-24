package com.xzsd.app.order.entity;

/**
 * 评价图片实体类
 * @author WangZeBin
 * @date 2020-04-23
 */
public class ImageInfo {
    /**
     * 图片编号
     */
    private String imageId;
    /**
     * 图片序号
     */
    private String imageNO;
    /**
     * 图片路径
     */
    private String imageUrl;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageNO() {
        return imageNO;
    }

    public void setImageNO(String imageNO) {
        this.imageNO = imageNO;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
