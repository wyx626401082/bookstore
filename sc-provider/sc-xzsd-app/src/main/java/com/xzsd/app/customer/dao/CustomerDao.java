package com.xzsd.app.customer.dao;

import com.xzsd.app.customer.entity.CustomerDO;
import com.xzsd.app.customer.entity.CustomerVO;
import org.apache.ibatis.annotations.Param;

/**
 * 客户信息管理接口
 * @author WangZeBin
 * @date 2020-04-20
 */
public interface CustomerDao {
    /**
     *统计用户账号数量
     * @param customerDO 用户信息
     * @return
     */
    int countUserAcct(CustomerDO customerDO);

    /**
     * 查询邀请码是否存在
     * @param inviteCode 门店邀请码
     * @return
     */
    int countInviteCode(@Param("inviteCode") String inviteCode);

    /**
     * 将客户信息保存到用户表（注册）
     * @param customerDO 客户信息
     * @return
     */
    int addUser(CustomerDO customerDO);

    /**
     * 将客户信息保存到客户表（注册）
     * @param customerDO
     * @return
     */
    int addCustomer(CustomerDO customerDO);
    /**
     * 查询客户绑定门店信息
     * @param userId 客户编号
     * @return
     */
    CustomerVO findCustomerById(String userId);

    /**
     * 修改客户绑定的邀请码
     * @param inviteCode 门店邀请码
     * @param userId 客户编号
     * @return
     */
    int updateInvite(@Param("inviteCode") String inviteCode,@Param("userId") String userId);
}
