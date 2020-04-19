package com.xzsd.pc.driver.entity;

/**
 * 司机信息实体类
 * @author WangZeBin
 * @date 2020-04-18
 */
public class DriverVO {
    /**
     * 司机编号
     */
    private String driverId;
    /**
     * 司机名称
     */
    private String driverName;
    /**
     * 司机账号
     */
    private String driverAcct;
    /**
     * 密码
     */
    private String driverPwd;
    /**
     * 司机电话号码
     */
    private String phone;
    /**
     * 司机身份证号码
     */
    private String idCard;
    /**
     *所在省份名称
     */
    private String provinceName;
    /**
     * 所在城市名称
     */
    private String cityName;
    /**
     * 所在区名称
     */
    private String countyName;
    /**
     * 版本号
     */
    private int version;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverAcct() {
        return driverAcct;
    }

    public void setDriverAcct(String driverAcct) {
        this.driverAcct = driverAcct;
    }

    public String getDriverPwd() {
        return driverPwd;
    }

    public void setDriverPwd(String driverPwd) {
        this.driverPwd = driverPwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
