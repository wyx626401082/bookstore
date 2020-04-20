package com.xzsd.pc.store.dao;

import com.xzsd.pc.store.entity.AreaVO;
import com.xzsd.pc.store.entity.StoreDO;
import com.xzsd.pc.store.entity.StoreVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 门店管理接口
 * @author WangZeBin
 * @date 2020-04-17
 */
public interface StoreDao {
    /**
     * 查找店长用户编号是否存在
     * @param userId 店长编号
     * @return
     */
    int countManagerId(@Param("userId") String userId);

    /**
     * 统计店长是否绑定门店
     * @param userId 店长编号
     * @return
     */
    int countIsStoreManager(@Param("userId") String userId);

    /**
     * 新增门店
     * @param storeDO 门店信息
     * @return
     */
    int addStore(StoreDO storeDO);

    /**
     * 删除门店信息
     * @param listId 门店信息集合
     * @param userId 当前用户编号
     * @return
     */
    int deleteStore(@Param("listId") List<String> listId, @Param("userId") String userId);

    /**
     * 修改门店信息
     * @param storeDO 门店信息
     * @return
     */
    int updateStoreById(StoreDO storeDO);

    /**
     * 查询门店列表（分页）
     * @param storeDO 门店信息
     * @return
     */
    List<StoreVO> listStoreByPage(StoreDO storeDO);

    /**
     * 查询门店详情
     * @param storeId 门店编号
     * @return
     */
    StoreVO findStoreById(@Param("storeId") String storeId);

    /**
     * 查询省市区列表
     * @param areaId 区域编号
     * @return
     */
    List<AreaVO> listArea(@Param("areaId") String areaId);
}
