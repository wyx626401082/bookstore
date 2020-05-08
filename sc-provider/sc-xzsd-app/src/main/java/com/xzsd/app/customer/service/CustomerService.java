package com.xzsd.app.customer.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.customer.dao.CustomerDao;
import com.xzsd.app.customer.entity.CustomerDO;
import com.xzsd.app.customer.entity.CustomerVO;
import com.xzsd.app.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 客户信息管理实现类
 * @author WangZeBin
 * @date 2020-04-20
 */
@Service
public class CustomerService {
    @Resource
    CustomerDao customerDao;

    /**
     * 注册（新增客户）
     * @param customerDO 客户信息
     * @return
     * @author WangZeBin
     * @date 2020-04-20
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCustomer(CustomerDO customerDO) {
        //检测账号是否存在
        int countUserAcct = customerDao.countUserAcct(customerDO);
        if(0 != countUserAcct) {
            return AppResponse.paramError("用户账号已存在，请重新输入！");
        }
        if(!"".equals(customerDO.getInviteCode()) && null != customerDO.getInviteCode()) {
            //验证邀请码是否存在
            int countInvite = customerDao.countInviteCode(customerDO.getInviteCode());
            if(0 == countInvite) {
                return AppResponse.paramError("门店邀请码不存在，请重新输入！");
            }
        }
        //新生成用户编号
        String userId = StringUtil.getCommonCode(2);
        customerDO.setUserId(userId);
        //新生成客户表编号
        String customerId = StringUtil.getCommonCode(2);
        customerDO.setCustomerId(customerId);
        //用户密码加密处理
        String pwd = PasswordUtils.generatePassword(customerDO.getUserPwd());
        customerDO.setUserPwd(pwd);
        customerDO.setIsDeleted(0);
        customerDO.setCreateBy(userId);
        customerDO.setModifyBy(userId);
        //将客户信息保存到用户表
        int countUser = customerDao.addUser(customerDO);
        if(0 == countUser) {
            return AppResponse.bizError("客户信息保存到用户表失败，请重试！");
        }
        //将客户信息保存到客户表
        int countCustomer = customerDao.addCustomer(customerDO);
        if(0 == countCustomer) {
            return AppResponse.bizError("客户信息保存到客户表失败，请重试！");
        }
        return AppResponse.success("注册成功！");
    }

    /**
     * 查询客户门店信息
     * @param userId 客户编号（用户编号）
     * @return
     * @author WangZeBin
     * @date 2020-04-20
     */
    public AppResponse findCustomerById(String userId) {
        CustomerVO customerVO = null;
        customerVO = customerDao.findCustomerById(userId);
        if (customerVO == null) {
            return AppResponse.paramError("无客户绑定门店信息查询结果！");
        }
        return AppResponse.success("客户绑定门店信息信息查询成功！", customerVO);
    }

    /**
     * 修改客户邀请码
     * @param inviteCode 门店邀请码
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateInvite(String inviteCode, String userId) {
        AppResponse appResponse = AppResponse.success("邀请码修改成功！");
        //验证邀请码是否存在
        int countInvite = customerDao.countInviteCode(inviteCode);
        if(0 == countInvite) {
            appResponse = AppResponse.paramError("门店邀请码不存在，请重新输入！");
            return appResponse;
        }
        //修改用户信息
        int count = customerDao.updateInvite(inviteCode,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("修改密码失败，请重试！");
            return appResponse;
        }
        return appResponse;
    }
}
