package com.xzsd.app.driver.dao;

import com.xzsd.app.driver.entity.StoreInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 司机端管理接口
 * @author WangZeBin
 * @date 2020-04-24
 */
public interface DriverDao {
    /**
     * 查询司机负责门店信息
     * @param userId 司机用户编号
     * @return
     */
    List<StoreInfo> findStore(@Param("userId") String userId);
}
