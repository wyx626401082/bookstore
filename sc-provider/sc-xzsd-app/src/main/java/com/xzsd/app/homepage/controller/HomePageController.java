package com.xzsd.app.homepage.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.homepage.service.HomePageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 客户端首页展示管理
 * @author WangZeBin
 * @date 2020-04-20
 */
@RestController
@RequestMapping("/homePage")
public class HomePageController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(HomePageController.class);

    @Resource
    HomePageService homePageService;

    /**
     * 首页轮播图
     * @return
     * @author WangZeBin
     * @date 2020-04-20
     */
    @RequestMapping(value="listBanner")
    public AppResponse listBanner() {
        try {
            return homePageService.listBanner();
        } catch (Exception e) {
            logger.error("首页轮播图查询异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询首页热门商品
     * @return
     * @author WangZeBin
     * @date 2020-04-20
     */
    @RequestMapping(value="listHostGoods")
    public AppResponse listHostGoods() {
        try {
            return homePageService.listHostGoods();
        } catch (Exception e) {
            logger.error("首页热门商品查询异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
