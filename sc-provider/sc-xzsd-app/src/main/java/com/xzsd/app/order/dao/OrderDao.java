package com.xzsd.app.order.dao;

import com.xzsd.app.order.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单模块接口
 * @author WangZeBin
 * @date 2020-04-22
 */
public interface OrderDao {
    /**
     * 查询商品数量及名称
     * @param listId 商品编号
     * @return
     */
    List<GoodsInfo> countGoodsNumber(@Param("listId") List<String> listId);

    /**
     * 新增订单（主表）
     * @param orderDO 订单信息
     * @return
     */
    int addOrder(OrderDO orderDO);

    /**
     * 将订单信息保存到订单明细表
     * @param orderDTOList 订单信息集合
     * @return
     */
    int addOrderDetail(@Param("orderDTOList") List<OrderDTO> orderDTOList);

    /**
     * 更新商品库存(新增)
     * @param orderDTOList 订单信息集合
     * @param userId 当前用户编号
     * @return
     */
    int updateGoodsInventory(@Param("orderDTOList") List<OrderDTO> orderDTOList, @Param("userId") String userId);

    /**
     * 更新商品库存（修改）
     * @param orderId 订单编号
     * @param userId 当前用户编号
     * @return
     */
    int updateInventory(@Param("orderId") String orderId, @Param("userId") String userId);

    /**
     * 查询订单列表（分页）
     * @param orderDO 查询信息
     * @return
     */
    List<OrderVO> listOrderByPage(OrderDO orderDO);

    /**
     * 查询订单详情
     * @param orderId 订单编号
     * @return
     */
    OrderVO findOrderById(@Param("orderId") String orderId);

    /**
     * 修改订单状态
     * @param orderDO
     * @return
     */
    int updateOrderState(OrderDO orderDO);

    /**
     * 查询订单评价页商品列表
     * @param orderId 订单编号
     * @return
     */
    List<GoodsInfo> listGoodsForEvaluate(@Param("orderId") String orderId);

    /**
     * 新增订单评价
     * @param evaluateList 评价信息
     * @return
     */
    int addEvaluate(@Param("evaluateList") List<EvaluateInfo> evaluateList);

    /**
     * 新增评价图片
     * @param evaluateList 评价图片信息
     * @return
     */
    int addEvaluateImage(@Param("evaluateList") List<EvaluateInfo> evaluateList);
}
