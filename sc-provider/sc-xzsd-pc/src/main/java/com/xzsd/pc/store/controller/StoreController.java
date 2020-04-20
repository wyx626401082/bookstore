package com.xzsd.pc.store.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.entity.StoreDO;
import com.xzsd.pc.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 门店管理增删改查
 * @author WangZeBin
 * @date 2020-04-17
 */
@RestController
@RequestMapping("/store")
public class StoreController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(StoreController.class);

    @Resource
    StoreService storeService;

    /**
     * 新增门店
     * @param storeDO 门店信息
     * @return
     * @author WangZeBin
     * @date 2020-04-17
     */
    @PostMapping("addStore")
    public AppResponse addStore(StoreDO storeDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            storeDO.setCreateBy(userId);
            AppResponse appResponse = storeService.addStore(storeDO);
            return appResponse;
        } catch (Exception e) {
            logger.error("门店新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除门店信息
     * @param storeId 门店编号
     * @return
     * @author WangZeBin
     * @date 2020-04-17
     */
    @PostMapping("deleteStore")
    public AppResponse deleteStore(String storeId) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return storeService.deleteStore(storeId, userId);
        } catch (Exception e) {
            logger.error("门店删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改门店信息
     * @param storeDO 门店信息
     * @return
     * @author WangZeBin
     * @date 2020-04-17
     */
    @PostMapping("updateStoreById")
    public AppResponse updateStoreById(StoreDO storeDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            storeDO.setModifyBy(userId);
            return storeService.updateStoreById(storeDO);
        } catch (Exception e) {
            logger.error("修改门店信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询门店列表（分页）
     * @param storeDO 门店信息
     * @return
     * @author WangZeBin
     * @date 2020-04-17
     */
    @RequestMapping(value="listStore")
    public AppResponse listStore(StoreDO storeDO) {
        try {
            //获取用户编号（用于店长角色）
            String userId = SecurityUtils.getCurrentUserId();
            storeDO.setUserId(userId);
            return storeService.listStore(storeDO);
        } catch(Exception e) {
            logger.error("查询门店列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询门店详情
     * @param storeId 门店编号
     * @return
     * @author WangZeBin
     * @date 2020-04-17
     */
    @RequestMapping(value="findStoreById")
    public AppResponse findStoreById(String storeId) {
        try {
            return storeService.findUserById(storeId);
        } catch (Exception e) {
            logger.error("查询门店详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询省市区列表
     * @param areaId 区域编号
     * @return
     * @author WangZeBin
     * @date 2020-04-17
     */
    @RequestMapping(value="listArea")
    public AppResponse listArea(String areaId) {
        try {
            return storeService.listArea(areaId);
        } catch(Exception e) {
            logger.error("查询省市区列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
