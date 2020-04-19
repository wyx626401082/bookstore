package com.xzsd.app.user.entity;

/**
 * 用户信息实体类（传入参数）
 * @author WangZeBin
 * @date 2020-04-19
 */
public class UserDO {
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 用户角色
     */
    private int role;
    /**
     * 原密码
     */
    private String oldPassword;
    /**
     * 新密码
     */
    private String newPassword;
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

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
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
