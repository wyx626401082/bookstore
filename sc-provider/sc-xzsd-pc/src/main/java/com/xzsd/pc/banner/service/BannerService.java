package com.xzsd.pc.banner.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.banner.dao.BannerDao;
import com.xzsd.pc.banner.entity.BannerDO;
import com.xzsd.pc.banner.entity.BannerVO;
import com.xzsd.pc.banner.entity.GoodsVO;
import com.xzsd.pc.utils.GlobalClass;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * 轮播图实现类
 * @author WangZeBin
 * @date 2020-04-14
 */
@Service
public class BannerService {
    @Resource
    BannerDao bannerDao;

    /**
     * 新增轮播图
     * @param bannerDO
     * @return
     * @author WangZeBin
     * @date 2020-04-14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addBanner(BannerDO bannerDO) {
        //新增轮播图
        bannerDO.setBannerId(StringUtil.getCommonCode(2));
        int count = bannerDao.addBanner(bannerDO);
        if(0 == count) {
            return AppResponse.bizError("新增轮播图失败，请重试！");
        }
        return AppResponse.success("新增轮播图成功！");
    }

    /**
     * 删除轮播图
     * @param bannerId 轮播图编号 多个用“，”隔开
     * @param userId 当前用户编号
     * @return
     * @author WangZeBin
     * @date 2020-04-14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteBanner(String bannerId, String userId) {
        List<String> listId = Arrays.asList(bannerId.split(","));
        AppResponse appResponse = AppResponse.success("删除轮播图成功！");
        //删除用户
        int count = bannerDao.deleteBanner(listId,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除轮播图失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改轮播图信息
     * @param bannerId 轮播图编号 多个用“，”隔开
     * @param bannerState 轮播图状态
     * @param version 版本号 多个用“，”隔开
     * @param userId 当前用户编号
     * @return
     * @author WangZeBin
     * @date 2020-04-14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateBannerById(String bannerId, int bannerState, String version, String userId) {
        AppResponse appResponse = AppResponse.success("修改轮播图成功");
        //将一个或多个轮播图id保存到list
        List<String> listId = Arrays.asList(bannerId.split(","));
        //将一个或多个版本号保存到list
        List<String> listVersion = Arrays.asList(version.split(","));
        int num = listId.size();
        //以轮播图编号为key，版本号为value，放到map中
        Map versionMap = new HashMap<String,Integer>(num);
        for(int i = 0; i < num; i++){
            int intVersion = Integer.valueOf(listVersion.get(i));
            versionMap.put(listId.get(i),intVersion);
        }
        //轮播图启用检测
        if(GlobalClass.enable == bannerState) {
            //检测选择的轮播图是否存在排序重复
            int countSameNO = bannerDao.countSameNO(listId);
            if(1 != countSameNO) {
                return AppResponse.paramError("选择的轮播图中存在排序重复，请重新选择！");
            }
            //检验在已启用轮播图排序是否存在
            int countBannerNO = bannerDao.countBannerNO(listId);
            if(0 != countBannerNO) {
                return AppResponse.paramError("存在与已启用轮播图排序重复，请重新选择！");
            }
            //检验商品是否在启用轮播图中存在
            int countGoodsId = bannerDao.countGoodsId(listId);
            if(0 != countGoodsId) {
                return AppResponse.paramError("商品在已启用轮播图中存在，请重新选择！");
            }
        }
        //修改轮播图信息
        int count = bannerDao.updateBannerById(bannerState,versionMap,userId);
        if(num > count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 查询轮播图列表（分页）
     * @param bannerDO
     * @return
     * @author WangZeBin
     * @date 2020-04-14
     */
    public AppResponse listBanner(BannerDO bannerDO) {
        if(!"".equals(bannerDO.getState()) && null != bannerDO.getState()) {
            bannerDO.setBannerState(Integer.valueOf(bannerDO.getState()));
        }
        List<BannerVO> bannerVOList = bannerDao.listBannerByPage(bannerDO);
        return AppResponse.success("查询轮播图列表成功！", getPageInfo(bannerVOList));
    }

    /**
     * 查询商品选择列表（分页）
     * @param bannerDO
     * @return
     * @author WangZeBin
     * @date 2020-04-14
     */
    public AppResponse listGoods(BannerDO bannerDO) {
        List<GoodsVO> goodsVOList = bannerDao.listGoodsByPage(bannerDO);
        return AppResponse.success("查询商品选择列表成功！", getPageInfo(goodsVOList));
    }
}
