package com.xzsd.pc.driver.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverDO;
import com.xzsd.pc.driver.entity.DriverVO;
import com.xzsd.pc.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * 司机管理实现类
 * @author WangZeBin
 * @date 2020-04-18
 */
@Service
public class DriverService {
    @Resource
    DriverDao driverDao;

    /**
     * 新增司机
     * @param driverDO 司机用户信息
     * @return
     * @author WangZeBin
     * @date 2020-04-18
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver(DriverDO driverDO) {
        //检测账号是否存在
        int countUserAcct = driverDao.countUserAcct(driverDO);
        if(0 != countUserAcct) {
            return AppResponse.paramError("用户账号已存在，请重新输入！");
        }
        //用户密码加密处理
        String pwd = PasswordUtils.generatePassword(driverDO.getDriverPwd());
        driverDO.setDriverPwd(pwd);
        //生成司机用户编号
        driverDO.setUserId(StringUtil.getCommonCode(2));
        //生成司机编号
        driverDO.setDriverId(StringUtil.getCommonCode(2));
        driverDO.setIsDeleted(0);
        //新增司机用户
        int countUser = driverDao.addDriver(driverDO);
        if(0 == countUser) {
            return AppResponse.bizError("新增司机用户信息失败，请重试！");
        }
        //保存司机信息
        int countDriver = driverDao.saveDriverInfo(driverDO);
        if(0 == countDriver) {
            return AppResponse.bizError("保存司机信息表失败，请重试！");
        }
        return AppResponse.success("新增司机用户成功！");
    }

    /**
     * 删除司机
     * @param driverId 司机用户编号
     * @param userId 当前用户编号
     * @return
     * @author WangZeBin
     * @date 2020-04-18
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriver(String driverId, String userId) {
        List<String> listId = Arrays.asList(driverId.split(","));
        AppResponse appResponse = AppResponse.success("删除司机用户成功！");
        //删除司机
        int count = driverDao.deleteDriver(listId,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除司机用户失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改司机信息
     * @param driverDO 司机用户新信息
     * @return
     * @author WangZeBin
     * @date 2020-04-18
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriverById(DriverDO driverDO) {
        AppResponse appResponse = AppResponse.success("司机信息修改成功");
        //检测账号是否存在
        int countUserAcct = driverDao.countUserAcct(driverDO);
        if(0 != countUserAcct) {
            return AppResponse.success("用户账号已存在，请重新输入！");
        }
        //密码加密处理
        String pwd = PasswordUtils.generatePassword(driverDO.getDriverPwd());
        driverDO.setDriverPwd(pwd);
        //修改司机用户信息
        int count = driverDao.updateDriverById(driverDO);
        if(0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 查询司机信息列表（分页）
     * @param driverDO 司机信息
     * @return
     * @author WangZeBin
     * @date 2020-04-18
     */
    public AppResponse listDriver(DriverDO driverDO) {
        List<DriverVO> driverVOList = driverDao.listDriverByPage(driverDO);
        return AppResponse.success("查询司机信息列表成功！", getPageInfo(driverVOList));
    }

    /**
     * 查询司机详情
     * @param driverId 司机编号
     * @return
     * @author WangZeBin
     * @date 2020-04-18
     */
    public AppResponse findDriverById(String driverId) {
        DriverVO driverVO = null;
        driverVO = driverDao.findDriverById(driverId);
        if (driverVO == null) {
            return AppResponse.success("无司机用户详情查询结果");
        }
        return AppResponse.success("查询司机用户详情成功", driverVO);
    }
}
