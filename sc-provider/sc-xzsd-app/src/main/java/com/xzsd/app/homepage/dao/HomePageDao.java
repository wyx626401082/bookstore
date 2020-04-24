package com.xzsd.app.homepage.dao;

import com.xzsd.app.homepage.entity.HomePageInfo;

import java.util.List;

/**
 * 客户端首页展示接口
 * @author WangZeBin
 * @date 2020-04-20
 */
public interface HomePageDao {
    /**
     * 查询首页轮播图列表
     * @return
     */
    List<HomePageInfo> listBanner();

    /**
     * 查询热门商品展示数量
     * @return
     */
    int findShowNumber();
    /**
     * 查询首页热门商品列表
     * @return
     */
    List<HomePageInfo> listHostGoods(int showNumber);
}
