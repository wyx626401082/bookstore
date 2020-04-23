package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderDO;
import com.xzsd.pc.order.entity.OrderVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 订单管理接口
 * @author WangZebin
 * @date 2020-04-15
 */
public interface OrderDao {
    /**
     * 查询订单状态
     * @param listId 订单编号
     * @return
     */
    List<Integer> countOrderState(@Param("listId") List<String> listId);

    /**
     * 修改订单状态
     * @param orderState 订单状态
     * @param versionMap 订单编号->版本号map
     * @param userId 当前用户编号
     * @return
     */
    int updateOrderById(@Param("orderState") int orderState, @Param("versionMap") Map<String,Integer> versionMap, @Param("userId") String userId);

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
    List<OrderVO> findOrderById(@Param("orderId") String orderId);
}
