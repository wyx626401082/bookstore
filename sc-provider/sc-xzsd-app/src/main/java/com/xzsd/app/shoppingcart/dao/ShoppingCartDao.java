package com.xzsd.app.shoppingcart.dao;

import com.xzsd.app.shoppingcart.entity.ShoppingCartDO;
import com.xzsd.app.shoppingcart.entity.ShoppingCartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 购物车管理接口
 * @author WangZeBin
 * @date 2020-04-21
 */
public interface ShoppingCartDao {
    /**
     * 统计商品数量
     * @param goodsId 商品编号
     * @return
     */
    int countGoodsNum(@Param("goodsId") String goodsId);

    /**
     * 统计商品在购物车中的数量
     * @param goodsId 商品编号
     * @param userId 用户编号
     * @return
     */
    int countGoodsNumAtCart(@Param("goodsId") String goodsId, @Param("userId") String userId);

    /**
     * 新增购物车
     * @param shoppingCartDO 购物车信息
     * @return
     */
    int addShoppingCart(ShoppingCartDO shoppingCartDO);

    /**
     * 删除购物车
     * @param listId 购物车编号
     * @param userId 当前用户编号
     * @return
     */
    int deleteShoppingCart(@Param("listId") List<String> listId, @Param("userId") String userId);

    /**
     * 修改购物车商品数量
     * @param shoppingCartDO 购物车信息
     * @return
     */
    int updateShoppingCart(ShoppingCartDO shoppingCartDO);

    /**
     * 查询购物车列表（分页）
     * @param shoppingCartDO
     * @return
     */
    List<ShoppingCartVO> listShoppingCartByPage(ShoppingCartDO shoppingCartDO);
}
