package com.xzsd.app.user.dao;

import com.xzsd.app.user.entity.UserDO;
import com.xzsd.app.user.entity.UserVO;
import org.apache.ibatis.annotations.Param;

/**
 * 公用部分用户信息管理接口
 * @author WangZeBin
 * @date 2020-04-19
 */
public interface UserDao {
    /**
     * 查询用户信息
     * @return
     * @param userId 当前登录用户编号
     */
    UserVO findUserInformation(@Param("userId") String userId);

    /**
     * 查找用户原密码与角色编号
     * @param userId 当前登录用户编号
     * @return用户原密码
     */
    UserDO findUserPassword(@Param("userId") String userId);

    /**
     * 修改用户密码
     * @param userDO 用户信息
     * @return
     */
    int updatePassword(UserDO userDO);
}
