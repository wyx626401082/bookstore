package com.xzsd.pc.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.entity.OrderDO;
import com.xzsd.pc.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单管理删改查
 * @author WangZeBin
 * @author WangZebin
 * @date 2020-04-15
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(OrderController.class);

    @Resource
    OrderService orderService;

    /**
     * 修改订单信息
     * @param orderId 订单编号，多个用“，”隔开
     * @param orderState 订单状态
     * @param version 版本号，多个用“，”隔开
     * @return
     * @author WangZebin
     * @date 2020-04-15
     */
    @PostMapping("updateOrderById")
    public AppResponse updateOrderById(String orderId, int orderState, String version) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return orderService.updateOrderById(orderId,orderState,version,userId);
        } catch (Exception e) {
            logger.error("修改订单信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单列表（分页）
     * @param orderDO
     * @return
     * @author WangZebin
     * @date 2020-04-15
     */
    @RequestMapping(value="listOrder")
    public AppResponse listOrder(OrderDO orderDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            orderDO.setManagerId(userId);
            return orderService.listOrder(orderDO);
        } catch(Exception e) {
            logger.error("查询订单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单详情
     * @param orderId 订单编号
     * @return
     * @author WangZebin
     * @date 2020-04-15
     */
    @RequestMapping(value="findOrderById")
    public AppResponse findOrderById(String orderId) {
        try {
            return orderService.findOrderById(orderId);
        } catch (Exception e) {
            logger.error("查询订单详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
