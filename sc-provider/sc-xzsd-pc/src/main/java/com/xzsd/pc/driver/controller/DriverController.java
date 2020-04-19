package com.xzsd.pc.driver.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driver.entity.DriverDO;
import com.xzsd.pc.driver.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 司机管理增删改查
 * @author WangZebin
 * @date 2020-04-18
 */
@RestController
@RequestMapping("/driver")
public class DriverController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(DriverController.class);

    @Resource
    DriverService driverService;

    /**
     * 新增用户司机
     * @param driverDO 司机用户信息
     * @return
     * @author WangZeBin
     * @date 2020-04-18
     */
    @PostMapping("addDriver")
    public AppResponse addDriver(DriverDO driverDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            driverDO.setCreateBy(userId);
            AppResponse appResponse = driverService.addDriver(driverDO);
            return appResponse;
        } catch (Exception e) {
            logger.error("司机用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除司机用户信息
     * @param driverId 司机用户编号
     * @return
     * @author WangZeBin
     * @date 2020-04-18
     */
    @PostMapping("deleteDriver")
    public AppResponse deleteDriver(String driverId) {
        try {
            //获取当前登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            return driverService.deleteDriver(driverId, userId);
        } catch (Exception e) {
            logger.error("司机用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改司机信息
     * @param driverDO 司机信息
     * @return
     * @author WangZeBin
     * @date 2020-04-18
     */
    @PostMapping("updateDriverById")
    public AppResponse updateDriverById(DriverDO driverDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            driverDO.setModifyBy(userId);
            return driverService.updateDriverById(driverDO);
        } catch (Exception e) {
            logger.error("修改司机用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询司机信息列表（分页）
     * @param driverDO 司机信息集合
     * @return
     * @author WangZeBin
     * @date 2020-04-18
     */
    @RequestMapping(value="listDriver")
    public AppResponse listDriver(DriverDO driverDO) {
        try {
            //获取当前登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            driverDO.setUserId(userId);
            return driverService.listDriver(driverDO);
        } catch(Exception e) {
            logger.error("查询司机用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询司机详情
     * @param driverId 司机用户编号
     * @return
     * @author WangZeBin
     * @date 2020-04-18
     */
    @RequestMapping(value="findDriverById")
    public AppResponse findDriverById(String driverId) {
        try {
            return driverService.findDriverById(driverId);
        } catch (Exception e) {
            logger.error("查询司机用户详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
