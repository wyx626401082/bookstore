package com.xzsd.app.manager.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.manager.dao.ManagerDao;
import com.xzsd.app.manager.entity.ManagerDO;
import com.xzsd.app.manager.entity.OrderVO;
import com.xzsd.app.manager.entity.UserInfo;
import com.xzsd.app.utils.GlobalClass;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * 店长端管理实现类
 * @author WangZeBin
 * @date 2020-04-24
 */
@Service
public class ManagerService {
    @Resource
    ManagerDao managerDao;

    /**
     * 查询店长订单列表(分页）
     * @param managerDO
     * @return
     * @author WangZeBin
     * @date 2020-04-24
     */
    public AppResponse listOrder(ManagerDO managerDO) {
        //查询店长订单列表
        List<OrderVO> orderVOList = managerDao.listOrderByPage(managerDO);
        if(null == orderVOList) {
            return AppResponse.bizError("查询订单列表失败！");
        }
        //计算订单中商品总数量
        for(int i = 0; i < orderVOList.size(); i++) {
            int goodsNum = 0;
            for(int j = 0; j < orderVOList.get(i).getGoodsList().size(); j++) {
                goodsNum += orderVOList.get(i).getGoodsList().get(j).getGoodsNumber();
            }
            orderVOList.get(i).setOrderAllNum(goodsNum);
        }
        return AppResponse.success("查询订单列表成功！", getPageInfo(orderVOList));
    }

    /**
     * 查询订单详情
     * @param orderId 订单编号
     * @return
     * @author WangZeBin
     * @date 2020-04-24
     */
    public AppResponse findOrderById(String orderId) {
        OrderVO orderVO = null;
        orderVO = managerDao.findOrderById(orderId);
        if (orderVO == null) {
            return AppResponse.success("无订单详情查询结果！");
        }
        //统计各个订单下商品总数
        int goodsNum = 0;
        for(int i = 0; i < orderVO.getGoodsList().size(); i++) {
            goodsNum += orderVO.getGoodsList().get(i).getGoodsNumber();
        }
        orderVO.setOrderAllNum(goodsNum);
        return AppResponse.success("查询订单详情成功！", orderVO);
    }

    /**
     * 查询店长信息
     * @param userId 店长编号
     * @return
     * @author WangZeBin
     * @date 2020-04-24
     */
    public AppResponse findManager(String userId) {
        UserInfo userInfo = null;
        userInfo = managerDao.findManager(userId);
        if (userInfo == null) {
            return AppResponse.success("无店长信息查询结果！");
        }
        return AppResponse.success("查询店长信息成功！", userInfo);
    }


    /**
     * 查询司机信息
     * @param userId 店长编号
     * @return
     * @author WangZeBin
     * @date 2020-04-24
     */
    public AppResponse findDriver(String userId) {
        List<UserInfo> userInfoList = managerDao.findDriver(userId);
        if (userInfoList == null) {
            return AppResponse.success("无司机信息查询结果！");
        }
        return AppResponse.success("查询司机信息成功！", userInfoList);
    }

    /**
     * 修改订单状态
     * @param managerDO
     * @return
     * @author WangZeBin
     * @date 2020-04-24
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(ManagerDO managerDO) {
        AppResponse appResponse = AppResponse.success("修改订单状态成功！");
        //修改订单状态
        int count = managerDao.updateOrderState(managerDO);
        if(0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        //取消订单时更新商品库存
        if(GlobalClass.cancelOrder.equals(managerDO.getOrderState())){
            int countUpdate = managerDao.updateInventory(managerDO.getOrderId(),managerDO.getUserId());
            if(0 == countUpdate) {
                return AppResponse.bizError("更新商品库存失败！");
            }
        }
        return appResponse;
    }
}
