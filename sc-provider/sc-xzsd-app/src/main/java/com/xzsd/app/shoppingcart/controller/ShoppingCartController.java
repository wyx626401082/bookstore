package com.xzsd.app.shoppingcart.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.shoppingcart.entity.ShoppingCartDO;
import com.xzsd.app.shoppingcart.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 购物车管理
 * @author WangZeBin
 * @date 2020-04-21
 */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ShoppingCartController.class);

    @Resource
    ShoppingCartService shoppingCartService;

    /**
     * 新增购物车
     * @param shoppingCartDO
     * @return
     * @author WangZeBin
     * @date 2020-04-21
     */
    @PostMapping("addShoppingCart")
    public AppResponse addShoppingCart(ShoppingCartDO shoppingCartDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            shoppingCartDO.setUserId(userId);
            shoppingCartDO.setCreateBy(userId);
            AppResponse appResponse = shoppingCartService.addShoppingCart(shoppingCartDO);
            return appResponse;
        } catch (Exception e) {
            logger.error("购物车新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除购物车
     * @param shoppingCartId
     * @return
     * @author WangZeBin
     * @date 2020-04-21
     */
    @PostMapping("deleteShoppingCart")
    public AppResponse deleteShoppingCart(String shoppingCartId) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return shoppingCartService.deleteShoppingCart(shoppingCartId, userId);
        } catch (Exception e) {
            logger.error("购物车删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改购物车商品数量
     * @param shoppingCartDO
     * @return
     * @author WangZeBin
     * @date 2020-04-21
     */
    @PostMapping("updateShoppingCart")
    public AppResponse updateShoppingCart(ShoppingCartDO shoppingCartDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            shoppingCartDO.setModifyBy(userId);
            return shoppingCartService.updateShoppingCart(shoppingCartDO);
        } catch (Exception e) {
            logger.error("修改购物车信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询购物车列表（分页）
     * @param shoppingCartDO
     * @return
     * @author WangZeBin
     * @date 2020-04-21
     */
    @RequestMapping(value="listShoppingCart")
    public AppResponse listShoppingCart(ShoppingCartDO shoppingCartDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            shoppingCartDO.setUserId(userId);
            return shoppingCartService.listShoppingCart(shoppingCartDO);
        } catch(Exception e) {
            logger.error("查询购物车列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
