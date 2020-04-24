package com.xzsd.app.homepage.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.homepage.dao.HomePageDao;
import com.xzsd.app.homepage.entity.HomePageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客户端首页展示实现类
 * @author WangZeBin
 * @date 2020-04-20
 */
@Service
public class HomePageService {
    @Resource
    HomePageDao homePageDao;

    /**
     * 查询首页轮播图列表
     * @return
     * @author WangZeBin
     * @date 2020-04-20
     */
    public AppResponse listBanner() {
        List<HomePageInfo> bannerList = homePageDao.listBanner();
        return AppResponse.success("查询首页轮播图成功", bannerList);
    }

    /**
     * 查询首页热门商品列表
     * @return
     * @author WangZeBin
     * @date 2020-04-20
     */
    public AppResponse listHostGoods() {
        int showNumber = homePageDao.findShowNumber();
        List<HomePageInfo> hostGoodsList = homePageDao.listHostGoods(showNumber);
        return AppResponse.success("查询首页热门商品成功", hostGoodsList);
    }
}
