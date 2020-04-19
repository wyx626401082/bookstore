package com.xzsd.pc.driver.dao;

import com.xzsd.pc.driver.entity.DriverDO;
import com.xzsd.pc.driver.entity.DriverVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 司机管理接口
 * @author WangZebin
 * @date 2020-04-18
 */
public interface DriverDao {
    /**
     * 检测账号是否存在
     * @param driverDO 司机信息集合
     * @return
     */
    int countUserAcct(DriverDO driverDO);

    /**
     * 新增司机（用户表）
     * @param driverDO 司机信息
     * @return
     */
    int addDriver(DriverDO driverDO);

    /**
     * 保存司机信息（司机信息表）
     * @param driverDO
     * @return
     */
    int saveDriverInfo(DriverDO driverDO);

    /**
     * 删除司机信息
     * @param listId 司机编号集合
     * @param userId 当前用户编号
     * @return
     */
    int deleteDriver(@Param("listId") List<String> listId, @Param("userId") String userId);

    /**
     * 修改司机信息
     * @param driverDO 司机信息
     * @return
     */
    int updateDriverById(DriverDO driverDO);

    /**
     * 查询司机列表（分页）
     * @param driverDO 司机信息
     * @return
     */
    List<DriverVO> listDriverByPage(DriverDO driverDO);

    /**
     * 查询司机详情
     * @param driverId 司机用户编号
     * @return
     */
    DriverVO findDriverById(String driverId);
}
