package com.xzsd.pc.banner.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.banner.entity.BannerDO;
import com.xzsd.pc.banner.service.BannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 轮播图增删改查
 * @author WangZebin
 * @date 2020-04-14
 */
@RestController
@RequestMapping("/banner")
public class BannerController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(BannerController.class);

    @Resource
    BannerService bannerService;

    /**
     * 新增轮播图
     * @param bannerDO 轮播图信息
     * @return
     * @author WangZebin
     * @date 2020-04-14
     */
    @PostMapping("addBanner")
    public AppResponse addBanner(BannerDO bannerDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            bannerDO.setCreateBy(userId);
            AppResponse appResponse = bannerService.addBanner(bannerDO);
            return appResponse;
        } catch (Exception e) {
            logger.error("轮播图新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除轮播图
     * @param bannerId 轮播图编号 多个用“，”隔开
     * @return
     * @author WangZebin
     * @date 2020-04-14
     */
    @PostMapping("deleteBanner")
    public AppResponse deleteBanner(String bannerId) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return bannerService.deleteBanner(bannerId, userId);
        } catch (Exception e) {
            logger.error("轮播图删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改轮播图信息
     * @param bannerId 轮播图编号
     * @param bannerState 轮播图状态 0禁用，1启用
     * @return
     * @author WangZebin
     * @date 2020-04-14
     */
    @PostMapping("updateBannerById")
    public AppResponse updateUserById(String bannerId, int bannerState, int version) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return bannerService.updateBannerById(bannerId, bannerState, version, userId);
        } catch (Exception e) {
            logger.error("修改轮播图信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询轮播图列表（分页）
     * @param bannerDO 轮播图信息
     * @return
     * @author WangZebin
     * @date 2020-04-14
     */
    @RequestMapping(value="listBanner")
    public AppResponse listUser(BannerDO bannerDO) {
        try {
            return bannerService.listBanner(bannerDO);
        } catch(Exception e) {
            logger.error("查询轮播图列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品选择列表（分页）
     * @param bannerDO 轮播图信息
     * @return
     * @author WangZebin
     * @date 2020-04-14
     */
    @RequestMapping(value="listGoods")
    public AppResponse listGoods(BannerDO bannerDO) {
        try {
            return bannerService.listGoods(bannerDO);
        } catch(Exception e) {
            logger.error("查询商品选择列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
