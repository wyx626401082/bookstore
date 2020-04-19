package com.xzsd.app.user.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.user.dao.UserDao;
import com.xzsd.app.user.entity.UserDO;
import com.xzsd.app.user.entity.UserVO;
import com.xzsd.app.utils.GlobalClass;
import com.xzsd.app.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 公用部分用户信息管理实现类
 * @author WangZeBin
 * @date 2020-04-19
 */
@Service
public class UserService {
    @Resource
    UserDao userDao;

    /**
     * 查询用户信息
     * @param userId 当前登录用户编号
     * @return
     * @author WangZeBin
     * @date 2020-04-19
     */
    public AppResponse findUserInformation(String userId) {
        UserVO userVO = null;
        userVO = userDao.findUserInformation(userId);
        if (userVO == null) {
            return AppResponse.success("无当前登录用户信息查询结果");
        }
        return AppResponse.success("当前登录用户信息查询成功", userVO);
    }

    /**
     *修改用户密码
     * @param userDO
     * @return
     * @author WangZeBin
     * @date 2020-04-19
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updatePassword(UserDO userDO) {
        AppResponse appResponse = AppResponse.success("密码修改成功");
        //查询当前用户角色与原密码
        UserDO userInfo = userDao.findUserPassword(userDO.getUserId());
        userDO.setRole(userInfo.getRole());
        String oldPwd = userInfo.getOldPassword();
        //验证用户输入的原密码是否正确
        boolean bool = PasswordUtils.PasswordMacth(userDO.getOldPassword(),oldPwd);
        if(false == bool) {
            appResponse = AppResponse.paramError("原密码输入错误，请重新输入");
            return appResponse;
        }
        //用户密码加密处理
        String newPwd = PasswordUtils.generatePassword(userDO.getNewPassword());
        userDO.setNewPassword(newPwd);
        //修改用户信息
        int count = userDao.updatePassword(userDO);
        if(0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }
}
