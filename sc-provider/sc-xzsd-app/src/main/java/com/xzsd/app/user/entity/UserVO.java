package com.xzsd.app.user.entity;

/**
 * 用户信息实体类（传出参数）
 * @author WangZeBin
 * @date 2020-04-19
 */
public class UserVO {
    /**
     *用户id
     */
    private String userId;
    /**
     *用户名称
     */
    private String userName;
    /**
     * 用户头像路径
     */
    private String userImage;
    /**
     * 用户电话号码
     */
    private String userPhone;
    /**
     * 角色编号
     */
    private int role;
    /**
     * 版本号
     */
    private int version;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
