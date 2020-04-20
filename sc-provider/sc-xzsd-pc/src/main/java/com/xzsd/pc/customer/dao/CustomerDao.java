package com.xzsd.pc.customer.dao;

import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.entity.CustomerVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerDao {
    /**
     * 查询客户信息列表
     * @param customerInfo 客户信息集合
     * @return
     */
    List<CustomerVO> listCustomerByPage(CustomerInfo customerInfo);

    /**
     * 查询门店邀请码
     * @param userId 店长用户编号
     * @return
     */
    String findInviteCode(@Param("userId") String userId);
}
