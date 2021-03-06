package com.xzsd.pc.user.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserDO;
import com.xzsd.pc.user.entity.UserVO;
import com.xzsd.pc.utils.GlobalClass;
import com.xzsd.pc.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @Description 实现类
 * @author WangZeBin
 * @Date 2020-03-25
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * 新增用户
     * @param userDO
     * @return
     * @author WangZebin
     * @date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(UserDO userDO) {
        //用户操作权限验证
        int userRole = userDao.findUserRole(userDO.getCreateBy());
        if(userRole >= userDO.getRole()) {
            return AppResponse.paramError("无操作权限！");
        }
        //新生成用户编号
        userDO.setUserId(StringUtil.getCommonCode(2));
        //检测账号是否存在
        int countUserAcct = userDao.countUserAcct(userDO);
        if(0 != countUserAcct) {
            return AppResponse.paramError("用户账号已存在，请重新输入！");
        }
        //角色验证
        int role = userDO.getRole();
        if(role != GlobalClass.systemManager && role != GlobalClass.storeManager) {
            return AppResponse.paramError("用户角色输入错误，请重新输入");
        }
        //用户密码加密处理
        String pwd = PasswordUtils.generatePassword(userDO.getUserPwd());
        userDO.setUserPwd(pwd);
        userDO.setIsDeleted(0);
        int count = userDao.addUser(userDO);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 删除用户
     * @param userCode 选中的用户
     * @param userId 更新人
     * @return
     * @author WangZebin
     * @date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userId, String userCode) {
        List<String> listId = Arrays.asList(userId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        //用户操作权限验证
        int userRole = userDao.findUserRole(userCode);
        List<Integer> roleList = userDao.findUserRoleOnList(listId);
        for (int i = 0; i < roleList.size(); i++) {
            if(userRole >= roleList.get(i)) {
                return AppResponse.paramError("无操作权限！");
            }
        }
        //删除用户
        int count = userDao.deleteUser(listId,userCode);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改用户信息
     * @param userDO 用户新信息
     * @return
     * @author WangZeBin
     * @date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUserById(UserDO userDO) {
        AppResponse appResponse = AppResponse.success("修改成功");
        //用户操作权限验证
        int userRole = userDao.findUserRole(userDO.getModifyBy());
        if(userRole >= userDO.getRole()) {
            return AppResponse.paramError("无操作权限！");
        }
        //检测账号是否存在
        int countUserAcct = userDao.countUserAcct(userDO);
        if(0 != countUserAcct) {
            return AppResponse.paramError("用户账号已存在，请重新输入！");
        }
        //角色验证
        int role = userDO.getRole();
        if(role != GlobalClass.systemManager && role != GlobalClass.storeManager) {
            return AppResponse.paramError("用户角色输入错误，请重新输入");
        }
        //用户密码加密处理
        if(!"".equals(userDO.getUserPwd()) && null != userDO.getUserPwd()) {
            String oldPwd = userDao.findUserPwd(userDO.getUserId());
            if(!oldPwd.equals(userDO.getUserPwd())) {
                String pwd = PasswordUtils.generatePassword(userDO.getUserPwd());
                userDO.setUserPwd(pwd);
            }
        }
        //修改用户信息
        int count = userDao.updateUserById(userDO);
        if(0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 查询用户列表（分页）
     * @param userDO
     * @return
     * @author WangZeBin
     * @date 2020-03-27
     */
    public AppResponse listUser(UserDO userDO) {
        List<UserVO> userVOList = userDao.listUserByPage(userDO);
        return AppResponse.success("查询用户列表成功！", getPageInfo(userVOList));
    }

    /**
     * 查询用户详情
     * @param userId 被查询用户编号
     * @return
     * @author WangZeBin
     * @date 2020-03-27
     */
    public AppResponse findUserById(String userId) {
        UserVO userVO = null;
        userVO = userDao.findUserById(userId);
        if (userVO == null) {
            return AppResponse.success("无用户详情查询结果");
        }
        return AppResponse.success("查询用户详情成功", userVO);
    }

    /**
     * 顶部栏查询
     * @param userId 当前登录用户编号
     * @return
     * @author WangZeBin
     * @date 2020-04-17
     */
    public AppResponse getTopOfColumn(String userId) {
        UserVO userVO = null;
        userVO = userDao.getTopOfColumn(userId);
        if (userVO == null) {
            return AppResponse.success("无顶部栏查询结果");
        }
        return AppResponse.success("顶部栏查询成功", userVO);
    }
}
