package com.xzsd.pc.customer.dao;

import com.xzsd.pc.customer.entity.CustomerInfo;

import java.util.List;

public interface CustomerDao {
    /**
     * 查询客户信息列表
     * @param customerInfo 客户信息集合
     * @return
     */
    List<CustomerInfo> listCustomerByPage(CustomerInfo customerInfo);
}
