package com.xzsd.pc.order.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderDO;
import com.xzsd.pc.order.entity.OrderVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * 订单管理实现类
 * @author WangZebin
 * @date 2020-04-15
 */
@Service
public class OrderService {
    @Resource
    OrderDao orderDao;

    /**
     * 修改订单信息
     * @param orderDO
     * @return
     * @author WangZebin
     * @date 2020-04-15
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderById(OrderDO orderDO) {
        AppResponse appResponse = AppResponse.success("修改订单状态成功");
        //修改订单信息
        int count = orderDao.updateOrderById(orderDO);
        if(0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 查询订单列表（分页）
     * @param orderDO 订单信息集合
     * @return
     * @author WangZebin
     * @date 2020-04-15
     */
    public AppResponse listOrder(OrderDO orderDO) {
        //存在查询时间时，判断时间前后
        String start = orderDO.getPayTimeStart();
        String end = orderDO.getPayTimeEnd();
        //起始时间，终止时间存在，且起始时间大于终止时间
        if(null !=start && !"".equals(start) && null != end && !"".equals(end) && start.compareTo(end) > 0) {
            String str = start;
            orderDO.setPayTimeStart(end);
            orderDO.setPayTimeEnd(str);
        }
        //列表查询
        List<OrderVO> orderVOList = orderDao.listOrderByPage(orderDO);
        return AppResponse.success("查询成功！", getPageInfo(orderVOList));
    }

    /**
     * 查询订单详情
     * @param orderId 订单编号
     * @return
     * @author WangZebin
     * @date 2020-04-15
     */
    public AppResponse findOrderById(String orderId) {
        OrderVO orderVO = null;
        orderVO = orderDao.findOrderById(orderId);
        if (orderVO == null) {
            return AppResponse.notFound("无订单详情查询结果");
        } else {
            //计算商品总价
            BigDecimal num = new BigDecimal(orderVO.getGoodsNumber());
            BigDecimal price = new BigDecimal(orderVO.getGoodsPrice());
            String totalPrice = price.multiply(num).toString();
            orderVO.setTotalPrice(totalPrice);
        }
        return AppResponse.success("查询订单详情成功", orderVO);
    }

}
