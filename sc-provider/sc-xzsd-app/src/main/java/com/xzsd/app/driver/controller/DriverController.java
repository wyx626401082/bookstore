package com.xzsd.app.driver.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 司机端管理
 * @author WangZeBin
 * @date 2020-04-24
 */
@RestController
@RequestMapping("/driver")
public class DriverController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(DriverController.class);

    @Resource
    DriverService driverService;

    /**
     * 查询司机所负责门店信息
     * @return
     */
    @RequestMapping(value="findStore")
    public AppResponse findStore() {
        try {
            //获取当前用户编号
            String userId = SecurityUtils.getCurrentUserId();
            return driverService.findStore(userId);
        } catch(Exception e) {
            logger.error("查询司机所负责门店信息异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
