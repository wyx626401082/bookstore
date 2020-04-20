package com.xzsd.pc.goods.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goods.entity.GoodsDO;
import com.xzsd.pc.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * 增删改查
 * @author WangZeBin
 * @date 2020-03-30
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(GoodsController.class);

    @Resource
    GoodsService goodsService;

    /**
     * 新增商品
     * @param goodsDO
     * @return
     * @author WangZeBin
     * @date 2020-03-30
     */
    @PostMapping("/addGoods")
    public AppResponse addGoods(GoodsDO goodsDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            goodsDO.setCreateBy(userId);
            AppResponse appResponse = goodsService.addGoods(goodsDO);
            return appResponse;
        }catch(Exception e) {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品
     * @param goodsId 商品编号
     * @return
     * @author WangZebin
     * @date 2020-03-30
     */
    @PostMapping("/deleteGoods")
    public AppResponse deleteGoods(String goodsId) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return goodsService.deleteGoods(goodsId,userId);
        }catch (Exception e) {
            logger.error("商品删除失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品信息
     * @param goodsDO
     * @return
     * @author WangZebin
     * @date 2020-03-30
     */
    @PostMapping("/updateGoodsById")
    public AppResponse updateGoodsById(GoodsDO goodsDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            goodsDO.setModifyBy(userId);
            AppResponse appResponse = goodsService.updateGoodsById(goodsDO);
            return appResponse;
        }catch(Exception e) {
            logger.error("商品修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品状态（上架、下架）
     * @param goodsId 商品编号，多个用“，”隔开
     * @param goodsState 商品状态
     * @param version 版本号，多个用“，”隔开
     * @return
     * @author WangZebin
     * @date 2020-03-30
     */
    @PostMapping("/updateStateById")
    public AppResponse updateStateById(String goodsId, int goodsState, String version) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            AppResponse appResponse = goodsService.updateStateById(goodsId, goodsState, version, userId);
            return appResponse;
        }catch(Exception e) {
            logger.error("商品状态修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品详情
     * @param goodsId
     * @return
     * @author WangZebin
     * @date 2020-03-30
     */
    @RequestMapping(value = "findGoodsById")
    public AppResponse findGoodsById(String goodsId) {
        try{
            return goodsService.findGoodsById(goodsId);
        } catch(Exception e) {
            logger.error("查询商品详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品列表
     * @param goodsDO
     * @return
     * @author WangZeBin
     * @date 2020-03-30
     */
    @RequestMapping(value="listGoods")
    public AppResponse listGoods(GoodsDO goodsDO) {
        try {
            return goodsService.listGoods(goodsDO);
        } catch(Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品分类列表
     * @return
     * @author WangZeBin
     * @date 2020-03-30
     */
    @RequestMapping(value = "listClassify")
    public AppResponse listClassify(String classifyId) {
        try{
            return goodsService.listClassify(classifyId);
        } catch(Exception e) {
            logger.error("查询商品分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
