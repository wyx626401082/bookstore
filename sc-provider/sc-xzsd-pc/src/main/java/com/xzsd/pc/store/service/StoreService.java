package com.xzsd.pc.store.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.AreaVO;
import com.xzsd.pc.store.entity.StoreDO;
import com.xzsd.pc.store.entity.StoreVO;
import com.xzsd.pc.utils.RandomUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * 门店管理实现类
 * @author WangZeBin
 * @date 2020-04-17
 */
@Service
public class StoreService {
    @Resource
    StoreDao storeDao;

    /**
     * 新增门店
     * @param storeDO 门店信息
     * @return
     * @author WangZeBin
     * @date 2020-04-17
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(StoreDO storeDO) {
        //新建门店编号
        storeDO.setStoreId(StringUtil.getCommonCode(2));
        storeDO.setIsDeleted(0);
        //新建邀请码，根据门店编号生成YQM+随机六位字符
        String inviteCode = "YQM".concat(RandomUtils.toRandomCode(Long.valueOf(storeDO.getStoreId())));
        storeDO.setInviteCode(inviteCode);
        //新增门店
        int count = storeDao.addStore(storeDO);
        if(0 == count) {
            return AppResponse.bizError("新增门店失败，请重试！");
        }
        return AppResponse.success("新增门店成功！");
    }

    /**
     * 删除门店信息
     * @param storeId 门店编号
     * @param userId 当前用户编号
     * @return
     * @author WangZeBin
     * @date 2020-04-17
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStore(String storeId, String userId) {
        List<String> listId = Arrays.asList(storeId.split(","));
        AppResponse appResponse = AppResponse.success("删除门店成功！");
        //删除门店
        int count = storeDao.deleteStore(listId,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除门店失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改门店信息
     * @param storeDO 门店信息
     * @return
     * @author WangZeBin
     * @date 2020-04-17
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStoreById(StoreDO storeDO) {
        AppResponse appResponse = AppResponse.success("修改门店信息成功");
        //修改门店信息
        int count = storeDao.updateStoreById(storeDO);
        if(0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 查询门店列表（分页）
     * @param storeDO 门店信息
     * @return
     * @author WangZeBin
     * @date 2020-04-17
     */
    public AppResponse listStore(StoreDO storeDO) {
        List<StoreVO> storeVOList = storeDao.listStoreByPage(storeDO);
        return AppResponse.success("查询门店信息列表成功！", getPageInfo(storeVOList));
    }

    /**
     * 查询门店详情
     * @param storeId 门店编号
     * @return
     * @author WangZeBin
     * @date 2020-04-17
     */
    public AppResponse findUserById(String storeId) {
        StoreVO storeVO = null;
        storeVO = storeDao.findStoreById(storeId);
        if (storeVO == null) {
            return AppResponse.success("无门店详情查询结果");
        }
        return AppResponse.success("查询门店详情成功", storeVO);
    }

    /**
     * 查询省市区列表
     * @param areaId 区域编号
     * @return
     * @author WangZeBin
     * @date 2020-04-17
     */
    public AppResponse listArea(String areaId) {
        List<AreaVO> areaVOList = storeDao.listArea(areaId);
        return AppResponse.success("查询省市区列表成功！", areaVOList);
    }
}
