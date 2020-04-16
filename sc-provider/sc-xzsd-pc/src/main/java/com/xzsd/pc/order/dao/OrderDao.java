package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderDO;
import com.xzsd.pc.order.entity.OrderVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单管理接口
 * @author WangZebin
 * @date 2020-04-15
 */
public interface OrderDao {
    /**
     * 修改订单状态
     * @param orderDO 订单编号 订单状态 版本号 当前用户编号
     * @return
     */
    int updateOrderById(OrderDO orderDO);

    /**
     * 查询订单列表
     * @param orderDO 订单信息
     * @return
     */
    List<OrderVO> listOrderByPage(OrderDO orderDO);

    /**
     * 查询订单详情
     * @param orderId 订单编号
     * @return
     */
    OrderVO findOrderById(@Param("orderId") String orderId);
}
