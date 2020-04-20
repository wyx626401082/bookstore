package com.xzsd.pc.hostgoods.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.hostgoods.entity.HostGoodsDO;
import com.xzsd.pc.hostgoods.service.HostGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 热门商品增删改查
 * @author WangZeBin
 * @date 2020-04-14
 */
@RestController
@RequestMapping("/hostGoods")
public class HostGoodsController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(HostGoodsController.class);

    @Resource
    HostGoodsService hostGoodsService;

    /**
     * 新增热门商品
     * @param hostGoodsDO
     * @return
     * @author WangZeBin
     * @date 2020-04-14
     */
    @PostMapping("addHostGoods")
    public AppResponse addHostGoods(HostGoodsDO hostGoodsDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            hostGoodsDO.setCreateBy(userId);
            AppResponse appResponse = hostGoodsService.addHostGoods(hostGoodsDO);
            return appResponse;
        } catch (Exception e) {
            logger.error("热门商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除热门商品
     * @param hostGoodsId 热门商品编号 多个用“，”隔开
     * @return
     * @author WangZeBin
     * @date 2020-04-14
     */
    @PostMapping("deleteHostGoods")
    public AppResponse deleteHostGoods(String hostGoodsId) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return hostGoodsService.deleteHostGoods(hostGoodsId, userId);
        } catch (Exception e) {
            logger.error("热门商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改热门商品信息
     * @param hostGoodsDO 热门商品信息
     * @return
     * @author WangZeBin
     * @date 2020-04-14
     */
    @PostMapping("updateHostGoodsById")
    public AppResponse updateHostGoodsById(HostGoodsDO hostGoodsDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            hostGoodsDO.setModifyBy(userId);
            return hostGoodsService.updateHostGoodsById(hostGoodsDO);
        } catch (Exception e) {
            logger.error("修改热门商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门商品列表（分页）
     * @param hostGoodsDO 热门商品信息
     * @return
     * @author WangZeBin
     * @date 2020-04-14
     */
    @RequestMapping(value="listHostGoods")
    public AppResponse listHostGoods(HostGoodsDO hostGoodsDO) {
        try {
            return hostGoodsService.listHostGoods(hostGoodsDO);
        } catch(Exception e) {
            logger.error("查询热门商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门商品展示数量
     * @return
     * @author WangZeBin
     * @date 2020-04-14
     */
    @RequestMapping(value="findShowNumber")
    public AppResponse findShowNumber() {
        try {
            return hostGoodsService.findShowNumber();
        } catch(Exception e) {
            logger.error("查询热门商品展示数量异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改热门商品展示数量
     * @param showNumber 热门商品展示数量
     * @param version 版本号
     * @return
     * @author WangZeBin
     * @date 2020-04-14
     */
    @PostMapping("updateShowNumber")
    public AppResponse updateShowNumber(int showNumber, int version) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return hostGoodsService.updateShowNumber(showNumber,version,userId);
        } catch (Exception e) {
            logger.error("修改热门商品展示数量信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
