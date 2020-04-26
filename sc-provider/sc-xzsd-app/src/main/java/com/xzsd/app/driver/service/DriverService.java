package com.xzsd.app.driver.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.driver.entity.StoreInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 司机端管理
 * @author WangZeBin
 * @date 2020-04-24
 */
@Service
public class DriverService {
    @Resource
    DriverDao driverDao;

    /**
     * 查询司机所负责门店信息
     * @param userId 司机用户编号
     * @return
     */
    public AppResponse findStore(String userId) {
        //查询司机所负责门店信息
        List<StoreInfo> storeInfoList = driverDao.findStore(userId);
        if(null == storeInfoList) {
            return AppResponse.bizError("查询司机所负责门店信息失败！");
        }
        return AppResponse.success("查询司机所负责门店信息成功！", storeInfoList);
    }
}
