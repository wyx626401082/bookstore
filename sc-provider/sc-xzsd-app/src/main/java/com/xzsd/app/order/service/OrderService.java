package com.xzsd.app.order.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.order.dao.OrderDao;
import com.xzsd.app.order.entity.*;
import com.xzsd.app.utils.GlobalClass;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * 订单模块管理实现类
 * @author WangZeBin
 * @date 2020-04-22
 */
@Service
public class OrderService {
    @Resource
    OrderDao orderDao;

    /**
     * 新增订单
     * @param orderDO 订单信息
     * @return
     * @author WangZeBin
     * @date 2020-04-22
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(OrderDO orderDO) {
        //将多个数据保存到list中
        List<String> listGoodsId = Arrays.asList(orderDO.getGoodsId().split(","));
        List<String> listGoodsNum = Arrays.asList(orderDO.getGoodsNumber().split(","));
        List<String> listGoodsPrice = Arrays.asList(orderDO.getGoodsPrice().split(","));
        List<String> listCart = Arrays.asList(orderDO.getShoppingCartId().split(","));
        int num = listGoodsId.size();
        //查询商品库存
        List<GoodsInfo> goodsInfoList = orderDao.countGoodsNumber(listGoodsId);
        for(int i = 0; i < num; i++) {
            int goodsNum = Integer.valueOf(listGoodsNum.get(i));
            if(goodsNum < goodsInfoList.get(i).getGoodsNumber()) {
                return AppResponse.paramError("《"+goodsInfoList.get(i).getGoodsName()+"》"+" 库存不足，请重新选择商品数量！");
            }
        }
        //计算订单总价
        BigDecimal orderMoney = BigDecimal.valueOf(0);
        for(int i = 0; i < num; i++) {
            BigDecimal goodsNum = new BigDecimal(listGoodsNum.get(i));
            BigDecimal goodsPrice = new BigDecimal(listGoodsPrice.get(i));
            orderMoney = goodsPrice.multiply(goodsNum).add(orderMoney);
        }
        String totalMoney = orderMoney.toString();
        //新生成订单编号
        String orderId = StringUtil.getCommonCode(2);
        orderDO.setOrderMoney(totalMoney);
        orderDO.setOrderId(orderId);
        orderDO.setIsDeleted(0);
        //将订单信息保存到订单表（主表）
        int count = orderDao.addOrder(orderDO);
        if(0 == count) {
            return AppResponse.bizError("新增订单失败，请重试！");
        }
        //将数据保存到List
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for(int i=0; i < num; i++) {
            //订单明细表编号
            String orderDetailId = StringUtil.getCommonCode(2);
            //商品数量
            int goodsNum = Integer.valueOf(listGoodsNum.get(i));
            orderDTOList.add(
                    new OrderDTO(orderDO.getUserId(),
                                orderId,
                                orderDetailId,
                                listGoodsId.get(i),
                                goodsNum,
                                listGoodsPrice.get(i),
                                orderDO.getStoreId(),
                                listCart.get(i),
                            0));
        }
        //将订单信息保存到订单明细表
        int countDetail = orderDao.addOrderDetail(orderDTOList);
        if(num > countDetail) {
            return AppResponse.bizError("新增订单明细表失败，请重试！");
        }
        //更新商品库存、商品浏览量
        int countInventory = orderDao.updateGoodsInventory(orderDTOList,orderDO.getUserId());
        if(0 == countInventory) {
            return AppResponse.bizError("更新商品库存失败！");
        }
        //购物车编号List去重
        List<String> newListCart = new ArrayList<>(num);
        newListCart.addAll(new HashSet<>(listCart));
        //购物车编号List去0
        List<String> listId = new ArrayList<>();
        for(int i = 0; i < newListCart.size(); i++) {
            if(!"0".equals(newListCart.get(i))){
                listId.add(newListCart.get(i));
            }
        }
        //判断是否存在购物车需要删除
        if(0 != listId.size()) {
            int countDeleted = orderDao.deleteShoppingCart(listId,orderDO.getUserId());
            if (0 == countDeleted) {
                return AppResponse.bizError("删除购物车失败！");
            }
        }
        return AppResponse.success("新增订单成功！");
    }

    /**
     * 查询订单列表（分页）
     * @param orderDO
     * @return
     * @author WangZeBin
     * @date 2020-04-23
     */
    public AppResponse listOrder(OrderDO orderDO) {
        List<OrderVO> orderVOList = orderDao.listOrderByPage(orderDO);
        if(null == orderVOList){
            return AppResponse.bizError("查询订单列表失败，请重试!");
        }
        //统计各个订单下商品总数
        int num = orderVOList.size();
        for(int i = 0; i < num; i++){
            int numGoods = orderVOList.get(i).getGoodsList().size();
            int orderTotalNum = 0;
            for(int j = 0; j < numGoods; j++) {
                orderTotalNum += orderVOList.get(i).getGoodsList().get(j).getGoodsNumber();
            }
            orderVOList.get(i).setOrderAllNum(orderTotalNum);
        }
        return AppResponse.success("查询订单列表成功！", getPageInfo(orderVOList));
    }

    /**
     * 查询订单详情
     * @param orderId 订单编号
     * @return
     * @author WangZeBin
     * @date 2020-04-23
     */
    public AppResponse findOrderById(String orderId) {
        OrderVO orderVO = null;
        orderVO = orderDao.findOrderById(orderId);
        if (orderVO == null) {
            return AppResponse.success("无订单详情查询结果！");
        }
        //统计各个订单下商品总数
        int orderTotalNum = 0;
        for(int i = 0; i < orderVO.getGoodsList().size(); i++) {
            orderTotalNum += orderVO.getGoodsList().get(i).getGoodsNumber();
        }
        orderVO.setOrderAllNum(orderTotalNum);
        return AppResponse.success("查询订单详情成功！", orderVO);
    }

    /**
     * 修改订单状态
     * @param orderDO
     * @return
     * @author WangZeBin
     * @date 2020-04-23
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(OrderDO orderDO) {
        AppResponse appResponse = AppResponse.success("修改订单状态成功！");
        //修改订单状态
        int count = orderDao.updateOrderState(orderDO);
        if(0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        //取消订单时更新商品库存
        if(GlobalClass.cancelOrder.equals(orderDO.getOrderState())) {
            //查询订单中商品数量
            int countOrderGoods = orderDao.countOrderGoods(orderDO.getOrderId());
            //更新商品库存
            int countUpdate = orderDao.updateInventory(orderDO.getOrderId(),orderDO.getUserId());
            if(countOrderGoods != countUpdate) {
                return AppResponse.bizError("更新商品库存失败！");
            }
        }
        //确认收货时更新商品销售量
        if(GlobalClass.bePickup.equals(orderDO.getOrderState())) {
            //查询订单中商品数量
            int countOrderGoods = orderDao.countOrderGoods(orderDO.getOrderId());
            //更新商品销售量
            int countUpdate = orderDao.updateSalesNum(orderDO.getOrderId(),orderDO.getUserId());
            if(countOrderGoods != countUpdate) {
                return AppResponse.bizError("更新商品销售量失败！");
            }
        }
        return appResponse;
    }

    /**
     * 查询订单评价页商品列表
     * @param orderId 订单编号
     * @return
     * @author WangZeBin
     * @date 2020-04-23
     */
    public AppResponse listGoodsForEvaluate(String orderId) {
        List<GoodsInfo> goodsList = orderDao.listGoodsForEvaluate(orderId);
        if(null == goodsList) {
            return AppResponse.bizError("查询订单商品列表失败！");
        }
        return AppResponse.success("查询订单商品列表成功！", goodsList);
    }

    /**
     * 新增商品评价信息
     * @param evaluateDO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addEvaluate(EvaluateDO evaluateDO) {
        String userId = evaluateDO.getUserId();
        String orderId = evaluateDO.getOrderId();
        int num = evaluateDO.getEvaluateList().size();
        List<String> goodsIdList = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            //新建评价表编号
            String evaluateId = StringUtil.getCommonCode(2);
            //保存评价表编号、用户编号、订单编号到list中
            evaluateDO.getEvaluateList().get(i).setEvaluateId(evaluateId);
            evaluateDO.getEvaluateList().get(i).setUserId(userId);
            evaluateDO.getEvaluateList().get(i).setOrderId(orderId);
            //保存商品编号，用于更新商品评分
            goodsIdList.add(evaluateDO.getEvaluateList().get(i).getGoodsId());
            //保存图片编号到list
            int numImage = evaluateDO.getEvaluateList().get(i).getImageList().size();
            for(int j = 0; j < numImage; j++) {
                //新建评价图片编号
                evaluateDO.getEvaluateList().get(i).getImageList().get(j).setImageId(StringUtil.getCommonCode(2));
            }
        }
        //新增订单评价
        int countEvaluate = orderDao.addEvaluate(evaluateDO.getEvaluateList());
        if(0 == countEvaluate) {
            return AppResponse.bizError("新增订单商品评价失败，请重试！");
        }
        //保存评价图片
        int countImage = orderDao.addEvaluateImage(evaluateDO.getEvaluateList());
        if(0 == countImage) {
            return AppResponse.bizError("保存评价图片失败，请重试！");
        }
        //更新商品评价星级
        int countUpdate = orderDao.updateGoodsStarLevel(goodsIdList,evaluateDO.getUserId());
        if(num != countUpdate) {
            return AppResponse.bizError("商品评价星级更新失败，请重试！");
        }
        return AppResponse.success("新增订单商品评价成功！");
    }
}
