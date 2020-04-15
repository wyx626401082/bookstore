package com.xzsd.pc.hostgoods.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.hostgoods.dao.HostGoodsDao;
import com.xzsd.pc.hostgoods.entity.HostGoodsDO;
import com.xzsd.pc.hostgoods.entity.HostGoodsVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * 热门商品管理实现类
 * @author WangZeBin
 * @date 2020-04-14
 */
@Service
public class HostGoodsService {
    @Resource
    HostGoodsDao hostGoodsDao;

    /**
     * 新增热门商品
     * @param hostGoodsDO 热门商品信息
     * @return
     * @author WangZeBin
     * @date 2020-04-14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addHostGoods(HostGoodsDO hostGoodsDO) {
        //检验热门商品排序是否存在
        int countNO = hostGoodsDao.countHostGoodsNO(hostGoodsDO.getHostGoodsNO());
        if(0 != countNO) {
            return AppResponse.success("热门商品排序已存在，请重新输入！");
        }
        //检验商品是否已在热门商品中
        int countGoods = hostGoodsDao.countGoodsId(hostGoodsDO.getGoodsId());
        if(0 != countGoods) {
            return AppResponse.success("商品已存在，请重新输入！");
        }
        //创建热门商品编号
        hostGoodsDO.setHostGoodsId(StringUtil.getCommonCode(2));
        hostGoodsDO.setIsDeleted(0);
        int count = hostGoodsDao.addHostGoods(hostGoodsDO);
        if(0 == count) {
            return AppResponse.bizError("新增热门商品失败，请重试！");
        }
        return AppResponse.success("新增热门商品成功！");
    }

    /**
     * 删除热门商品
     * @param hostGoodsId 热门商品编号 多个用“，”隔开
     * @param userId 当前用户编号
     * @return
     * @author WangZeBin
     * @date 2020-04-14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHostGoods(String hostGoodsId, String userId) {
        List<String> listId = Arrays.asList(hostGoodsId.split(","));
        AppResponse appResponse = AppResponse.success("删除热门商品成功！");
        //删除热门商品
        int count = hostGoodsDao.deleteHostGoods(listId,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除热门商品失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改热门商品
     * @param hostGoodsDO 热门商品信息
     * @return
     * @author WangZeBin
     * @date 2020-04-14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHostGoodsById(HostGoodsDO hostGoodsDO) {
        AppResponse appResponse = AppResponse.success("修改热门商品成功");
        //检验热门商品排序是否存在
        int countNO = hostGoodsDao.countHostGoodsNO(hostGoodsDO.getHostGoodsNO());
        if(0 != countNO) {
            return AppResponse.success("热门商品排序已存在，请重新输入！");
        }
        //检验商品是否已在热门商品中
        int countGoods = hostGoodsDao.countGoodsId(hostGoodsDO.getGoodsId());
        if(0 != countGoods) {
            return AppResponse.success("商品已存在，请重新输入！");
        }
        //修改热门商品信息
        int count = hostGoodsDao.updateHostGoodsById(hostGoodsDO);
        if(0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 查询热门商品列表（分页）
     * @param hostGoodsDO 热门商品信息
     * @return
     * @author WangZeBin
     * @date 2020-04-14
     */
    public AppResponse listHostGoods(HostGoodsDO hostGoodsDO) {
        List<HostGoodsVO> hostGoodsVOList = hostGoodsDao.listHostGoodsByPage(hostGoodsDO);
        return AppResponse.success("查询热门商品列表成功！", getPageInfo(hostGoodsVOList));
    }

    /**
     * 查询热门商品展示数量
     * @return
     * @author WangZeBin
     * @date 2020-04-14
     */
    public AppResponse findShowNumber() {
        List<HostGoodsVO> hostGoodsVOList = hostGoodsDao.findShowNumber();
        return AppResponse.success("查询热门商品展示数量成功！", hostGoodsVOList);
    }

    /**
     * 修改热门商品展示数量
     * @param showNumber 展示数量
     * @param version 版本号
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateShowNumber(int showNumber, int version, String userId) {
        AppResponse appResponse = AppResponse.success("修改热门商品展示数量成功");
        //修改热门商品信息
        int count = hostGoodsDao.updateShowNumber(showNumber,version,userId);
        if(0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }
}
