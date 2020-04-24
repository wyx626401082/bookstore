package com.xzsd.app.shoppingcart.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.shoppingcart.dao.ShoppingCartDao;
import com.xzsd.app.shoppingcart.entity.ShoppingCartDO;
import com.xzsd.app.shoppingcart.entity.ShoppingCartVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * 购物车管理实现类
 * @author WangZeBin
 * @date 2020-04-21
 */
@Service
public class ShoppingCartService {
    @Resource
    ShoppingCartDao shoppingCartDao;

    /**
     * 新增购物车
     * @param shoppingCartDO 购物车信息
     * @return
     * @author WangZeBin
     * @date 2020-04-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addShoppingCart(ShoppingCartDO shoppingCartDO) {
        //新生成购物车编号
        shoppingCartDO.setShoppingCartId(StringUtil.getCommonCode(2));
        shoppingCartDO.setIsDeleted(0);
        //检测商品是否存在
        int countGoods = shoppingCartDao.countGoodsNum(shoppingCartDO.getGoodsId());
        if(0 == countGoods) {
            return AppResponse.paramError("商品不存在，请重新选择！");
        }
        //新增购物车
        int count = shoppingCartDao.addShoppingCart(shoppingCartDO);
        if(0 == count) {
            return AppResponse.bizError("新增购物车失败，请重试！");
        }
        return AppResponse.success("新增购物车成功！");
    }

    /**
     * 删除购物车
     * @param shoppingCartId 购物车id（多选时用逗号隔开）
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteShoppingCart(String shoppingCartId, String userId) {
        List<String> listId = Arrays.asList(shoppingCartId.split(","));
        AppResponse appResponse = AppResponse.success("删除购物车成功！");
        //删除购物车
        int count = shoppingCartDao.deleteShoppingCart(listId,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除购物车失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改购物车商品数量
     * @param shoppingCartDO 购物车信息
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateShoppingCart(ShoppingCartDO shoppingCartDO) {
        AppResponse appResponse = AppResponse.success("修改购物车商品数量成功");
        //修改购物车商品数量
        int count = shoppingCartDao.updateShoppingCart(shoppingCartDO);
        if(0 == count) {
            appResponse = AppResponse.bizError("修改购物车失败，请重试！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 查询购物车列表（分页）
     * @param shoppingCartDO
     * @return
     * @author WangZeBin
     * @date 2020-04-21
     */
    public AppResponse listShoppingCart(ShoppingCartDO shoppingCartDO) {
        List<ShoppingCartVO> shoppingCartList = shoppingCartDao.listShoppingCartByPage(shoppingCartDO);
        return AppResponse.success("查询购物车列表成功！", getPageInfo(shoppingCartList));
    }

}
