package com.xzsd.pc.order.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderDO;
import com.xzsd.pc.order.entity.OrderVO;
import com.xzsd.pc.utils.GlobalClass;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @param orderId 订单编号，多个用“，”隔开
     * @param orderState 订单状态
     * @param version 版本号，多个用“，”隔开
     * @param userId 当前登录用户编号
     * @return
     * @author WangZebin
     * @date 2020-04-15
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderById(String orderId, int orderState, String version, String userId) {
        AppResponse appResponse = AppResponse.success("修改订单状态成功！");
        //将订单id，以及与其对应版本号转化为List
        List<String> listId = Arrays.asList(orderId.split(","));
        List<String> listVersion = Arrays.asList(version.split(","));
        //验证订单是否已被取消
        List<Integer> stateList = orderDao.countOrderState(listId);
        for( int i = 0 ; i < stateList.size(); i++ ) {
            if(GlobalClass.beCancelled == stateList.get(i)){
                return AppResponse.paramError("存在已取消订单或已完成，请重新选择！");
            }
        }
        //以订单id为key，版本号为value存入Map
        int num = listId.size();
        Map versionMap = new HashMap<String,Integer>(num);
        for(int i = 0; i < num; i++) {
            int intVersion = Integer.valueOf(listVersion.get(i));
            versionMap.put(listId.get(i),intVersion);
        }
        //订单取消到货状态验证
        if(GlobalClass.cancelArrived == orderState){
            //验证订单是否为到货状态
            for( int i = 0 ; i < stateList.size(); i++ ) {
                if(GlobalClass.haveArrived != stateList.get(i)){
                    return AppResponse.paramError("存在订单不是到货状态！");
                }
            }
        }
        //订单取消已取货状态验证
        if(GlobalClass.cancelPickup == orderState){
            //验证订单是否为已取货状态
            for( int i = 0 ; i < stateList.size(); i++ ) {
                if(GlobalClass.bePickup != stateList.get(i)){
                    return AppResponse.paramError("存在订单不是已取货状态！");
                }
            }
        }
        //修改订单信息
        int count = orderDao.updateOrderById(orderState,versionMap,userId);
        if(num > count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        //取消订单时更新商品库存
        if(GlobalClass.cancelOrder == orderState) {
            //查询订单中商品数量
            int countOrderGoods = orderDao.countOrderGoods(listId);
            //更新商品库存
            int countUpdate = orderDao.updateInventory(listId,userId);
            if(countOrderGoods != countUpdate) {
                return AppResponse.bizError("更新商品库存失败！");
            }
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
        //转化订单状态数据类型
        String orderState = orderDO.getOrderState();
        if(!"".equals(orderState) && null != orderState){
            Integer state = Integer.valueOf(orderState);
            orderDO.setState(state);
        }
        //列表查询
        List<OrderVO> orderVOList = orderDao.listOrderByPage(orderDO);
        return AppResponse.success("查询订单列表成功！", getPageInfo(orderVOList));
    }

    /**
     * 查询订单详情
     * @param orderId 订单编号
     * @return
     * @author WangZebin
     * @date 2020-04-15
     */
    public AppResponse findOrderById(String orderId) {
        List<OrderVO>  orderVOList = orderDao.findOrderById(orderId);
        //计算商品总价
        for(int i = 0; i < orderVOList.size(); i++) {
            BigDecimal num = new BigDecimal(orderVOList.get(i).getGoodsNumber());
            BigDecimal price = new BigDecimal(orderVOList.get(i).getGoodsPrice());
            String totalPrice = price.multiply(num).toString();
            orderVOList.get(i).setTotalPrice(totalPrice);
        }
        return AppResponse.success("查询订单详情成功！", orderVOList);
    }
}
