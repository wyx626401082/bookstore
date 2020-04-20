package com.xzsd.pc.customer.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 客户管理
 * @author WangZeBin
 * @date 2020-04-06
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(CustomerController.class);

    @Resource
    CustomerService customerService;

    /**
     * 查询客户列表
     * @param customerInfo 客户信息集合
     * @return
     * @author WangZeBin
     * @date 2020-04-06
     */
    @RequestMapping(value="listCustomer")
    public AppResponse listCustomer(CustomerInfo customerInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            customerInfo.setUserId(userId);
            return customerService.listCustomer(customerInfo);
        } catch(Exception e) {
            logger.error("查询客户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
