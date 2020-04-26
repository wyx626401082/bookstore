package com.xzsd.app.manager.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.manager.entity.ManagerDO;
import com.xzsd.app.manager.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 店长端管理
 * @author WangZeBin
 * @date 2020-04-24
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ManagerController.class);

    @Resource
    ManagerService managerService;

    /**
     * 查询店长订单列表(分页）
     * @param managerDO
     * @return
     * @author WangZeBin
     * @date 2020-04-24
     */
    @RequestMapping(value="listOrder")
    public AppResponse listOrder(ManagerDO managerDO) {
        try {
            //获取当前用户编号
            String userId = SecurityUtils.getCurrentUserId();
            managerDO.setUserId(userId);
            return managerService.listOrder(managerDO);
        } catch(Exception e) {
            logger.error("查询店长订单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单详情
     * @param orderId 订单编号
     * @return
     * @author WangZeBin
     * @date 2020-04-24
     */
    @RequestMapping(value="findOrderById")
    public AppResponse findOrderById(String orderId) {
        try {
            return managerService.findOrderById(orderId);
        } catch (Exception e) {
            logger.error("查询订单详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询店长信息
     * @return
     * @author WangZeBin
     * @date 2020-04-24
     */
    @RequestMapping(value="findManager")
    public AppResponse findManager() {
        try {
            //获取当前用户编号
            String userId = SecurityUtils.getCurrentUserId();
            return managerService.findManager(userId);
        } catch (Exception e) {
            logger.error("查询店长信息异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询司机信息
     * @return
     * @author WangZeBin
     * @date 2020-04-24
     */
    @RequestMapping(value="findDriver")
    public AppResponse findDriver() {
        try {
            //获取当前用户编号
            String userId = SecurityUtils.getCurrentUserId();
            return managerService.findDriver(userId);
        } catch (Exception e) {
            logger.error("查询司机信息异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态
     * @param managerDO
     * @return
     * @author WangZeBin
     * @date 2020-04-24
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(ManagerDO managerDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            managerDO.setUserId(userId);
            return managerService.updateOrderState(managerDO);
        } catch (Exception e) {
            logger.error("修改订单状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
