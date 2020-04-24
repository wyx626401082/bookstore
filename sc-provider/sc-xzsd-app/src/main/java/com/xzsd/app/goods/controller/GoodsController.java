package com.xzsd.app.goods.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goods.entity.GoodsDO;
import com.xzsd.app.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品信息管理
 * @author WangZebin
 * @date 2020-04-21
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(GoodsController.class);

    @Resource
    GoodsService goodsService;

    /**
     * 查询商品详情
     * @param goodsId
     * @return
     * @author WangZebin
     * @date 2020-04-21
     */
    @RequestMapping(value="findGoodsById")
    public AppResponse findGoodsById(String goodsId) {
        try {
            return goodsService.findGoodsById(goodsId);
        } catch (Exception e) {
            logger.error("查询商品详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品评价列表(分页）
     * @param goodsDO
     * @return
     * @author WangZebin
     * @date 2020-04-21
     */
    @RequestMapping(value="listGoodsEvaluate")
    public AppResponse listGoodsEvaluate(GoodsDO goodsDO) {
        try {
            return goodsService.listGoodsEvaluate(goodsDO);
        } catch(Exception e) {
            logger.error("查询商品评价列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品一级分类列表
     * @return
     * @author WangZebin
     * @date 2020-04-21
     */
    @RequestMapping(value="listClassifyOne")
    public AppResponse listClassifyOne() {
        try {
            return goodsService.listClassifyOne();
        } catch(Exception e) {
            logger.error("查询商品一级分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品二级分类列表
     * @return
     * @author WangZebin
     * @date 2020-04-21
     */
    @RequestMapping(value="listClassifyTwo")
    public AppResponse listClassifyTwo(String classOneId) {
        try {
            return goodsService.listClassifyTwo(classOneId);
        } catch(Exception e) {
            logger.error("查询商品二级分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
