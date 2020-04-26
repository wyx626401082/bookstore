package com.xzsd.app.manager.dao;

import com.xzsd.app.manager.entity.ManagerDO;
import com.xzsd.app.manager.entity.OrderVO;
import com.xzsd.app.manager.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 店长端管理接口
 * @author WangZeBin
 * @date 2020-04-24
 */
public interface ManagerDao {
    /**
     * 查询店长订单列表(分页)
     * @param managerDO
     * @return
     */
    List<OrderVO> listOrderByPage(ManagerDO managerDO);

    /**
     * 查询店长订单详情
     * @param orderId 订单编号
     * @return
     */
    OrderVO findOrderById(@Param("orderId") String orderId);

    /**
     * 查找店长负责门店信息
     * @param userId 店长编号
     * @return
     */
    UserInfo findManager(@Param("userId") String userId);

    /**
     * 查找司机信息
     * @param userId 店长编号
     * @return
     */
    List<UserInfo> findDriver(@Param("userId") String userId);

    /**
     * 修改订单状态
     * @param managerDO
     * @return
     */
    int updateOrderState(ManagerDO managerDO);

    /**
     * 更新商品库存
     * @param orderId 订单编号
     * @param userId 当前用户编号
     * @return
     */
    int updateInventory(@Param("orderId") String orderId, @Param("userId") String userId);
}
