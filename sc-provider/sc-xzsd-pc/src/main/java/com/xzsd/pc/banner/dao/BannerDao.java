package com.xzsd.pc.banner.dao;

import com.xzsd.pc.banner.entity.BannerDO;
import com.xzsd.pc.banner.entity.BannerVO;
import com.xzsd.pc.banner.entity.GoodsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 轮播图管理接口
 * @author WangZeBin
 * @date 2020-04-14
 */
public interface BannerDao {
    /**
     * 统计轮播图各个排序数量
     * @param listId 轮播图编号集合
     * @return
     */
    int countBannerNO(@Param("listId") List<String> listId);

    /**
     * 统计轮播图中的商品数量
     * @param listId 轮播图编号集合
     * @return 最大重复数
     */
    int countGoodsId(@Param("listId") List<String> listId);

    /**
     * 检测选择轮播图是否存在排序重复
     * @param listId 轮播图编号集合
     * @return
     */
    int countSameNO(@Param("listId") List<String> listId);

    /**
     * 新增轮播图
     * @param bannerDO 轮播图信息
     * @return
     */
    int addBanner(BannerDO bannerDO);

    /**
     * 修改轮播图状态
     * @param bannerState 轮播图状态 0禁用，1启用
     * @param versionMap 轮播图编号->版本号map
     * @param userId 当前用户编号
     * @return
     */
    int updateBannerById(@Param("bannerState")  int bannerState, @Param("versionMap") Map<String,Integer> versionMap, @Param("userId") String userId);

    /**
     * 删除轮播图
     * @param listId 轮播图编号集合
     * @param userId 当前用户编号
     * @return
     */
    int deleteBanner(@Param("listId") List<String> listId, @Param("userId") String userId);

    /**
     * 查询轮播图列表（分页）
     * @param bannerDO 轮播图信息
     * @return
     */
    List<BannerVO> listBannerByPage(BannerDO bannerDO);

    /**
     * 查询商品列表（分页）
     * @param bannerDO 轮播图信息
     * @return
     */
    List<GoodsVO> listGoodsByPage(BannerDO bannerDO);
}
