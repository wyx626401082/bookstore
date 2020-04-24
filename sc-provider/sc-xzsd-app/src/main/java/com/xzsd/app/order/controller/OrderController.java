package com.xzsd.app.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.order.entity.EvaluateDO;
import com.xzsd.app.order.entity.OrderDO;
import com.xzsd.app.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单模块管理
 * @author WangZeBin
 * @date 2020-04-22
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(OrderController.class);

    @Resource
    OrderService orderService;

    /**
     * 新增订单
     * @param orderDO 订单信息
     * @return
     * @author WangZeBin
     * @date 2020-04-22
     */
    @PostMapping("addOrder")
    public AppResponse addOrder(OrderDO orderDO) {
        try {
            //获取当前用户编号
            String userId = SecurityUtils.getCurrentUserId();
            orderDO.setUserId(userId);
            orderDO.setCreateBy(userId);
            return orderService.addOrder(orderDO);
        } catch (Exception e) {
            logger.error("新增订单失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单列表（分页）
     * @param orderDO
     * @return
     * @author WangZeBin
     * @date 2020-04-23
     */
    @RequestMapping(value="listOrder")
    public AppResponse listOrder(OrderDO orderDO) {
        try {
            //获取当前用户编号
            String userId = SecurityUtils.getCurrentUserId();
            orderDO.setUserId(userId);
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
     * @author WangZeBin
     * @date 2020-04-23
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

    /**
     * 修改订单状态
     * @param orderDO
     * @return
     * @author WangZeBin
     * @date 2020-04-23
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(OrderDO orderDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            orderDO.setModifyBy(userId);
            return orderService.updateOrderState(orderDO);
        } catch (Exception e) {
            logger.error("修改订单状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单评价页商品列表
     * @param orderId 订单编号
     * @return
     * @author WangZeBin
     * @date 2020-04-23
     */
    @RequestMapping(value="listGoodsForEvaluate")
    public AppResponse listGoodsForEvaluate(String orderId) {
        try {
            return orderService.listGoodsForEvaluate(orderId);
        } catch(Exception e) {
            logger.error("查询订单商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 新增订单商品评价
     * @param evaluateDO
     * @return
     */
    @PostMapping("addEvaluate")
    public AppResponse addEvaluate(@RequestBody EvaluateDO evaluateDO) {
        try {
            //获取当前用户编号
            String userId = SecurityUtils.getCurrentUserId();
            evaluateDO.setUserId(userId);
            return orderService.addEvaluate(evaluateDO);
        } catch (Exception e) {
            logger.error("新增订单商品评价失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
