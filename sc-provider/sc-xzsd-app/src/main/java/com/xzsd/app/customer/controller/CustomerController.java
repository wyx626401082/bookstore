package com.xzsd.app.customer.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.customer.entity.CustomerDO;
import com.xzsd.app.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 客户信息管理
 * @author WangZeBin
 * @date 2020-04-20
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(CustomerController.class);

    @Resource
    CustomerService customerService;

    /**
     * 注册（新增客户）
     * @param customerDO 客户信息
     * @return
     * @author WangZeBin
     * @date 2020-04-20
     */
    @PostMapping("addCustomer")
    public AppResponse addCustomer(CustomerDO customerDO) {
        try {
            AppResponse appResponse = customerService.addCustomer(customerDO);
            return appResponse;
        } catch (Exception e) {
            logger.error("客户注册失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询客户信息
     * @return
     * @author WangZeBin
     * @date 2020-04-20
     */
    @RequestMapping(value="findCustomerById")
    public AppResponse findCustomerById() {
        try {
            //获取当前用户编号
            String userId = SecurityUtils.getCurrentUserId();
            return customerService.findCustomerById(userId);
        } catch (Exception e) {
            logger.error("客户信息查询异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改门店邀请码
     * @param inviteCode 门店邀请码
     * @return
     */
    @PostMapping("updateInvite")
    public AppResponse updateInvite(String inviteCode) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return customerService.updateInvite(inviteCode,userId);
        } catch (Exception e) {
            logger.error("修改门店邀请码错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
