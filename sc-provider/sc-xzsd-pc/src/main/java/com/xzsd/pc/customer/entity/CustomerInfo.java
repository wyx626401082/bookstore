package com.xzsd.pc.customer.entity;

import java.util.Date;

/**
 * 客户信息实体类
 * @author WangZebin
 * @date 2020-04-06
 */
public class CustomerInfo {
    /**
     *页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     *用户编码
     */
    private String customerNameId;
    /**
     * 用户名称
     */
    private String customerName;
    /**
     * 用户登录账号
     */
    private String customerNameAcct;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 性别 0 男 1 女
     */
    private int sex;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 备注
     */
    private String remark;
}
