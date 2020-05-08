package com.xzsd.pc.user.dao;


import com.xzsd.pc.user.entity.UserDO;
import com.xzsd.pc.user.entity.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户管理接口
 * @author WangZeBin
 * @Date 2020-03-25
 */
public interface UserDao {
    /**
     *统计用户账号数量
     * @param userDO 用户信息
     * @return
     */
    int countUserAcct(UserDO userDO);

    /**
     * 查询用户密码
     * @param userId 用户编号
     * @return
     */
    String findUserPwd(@Param("userId") String userId);

    /**
     * 查询用户密码
     * @param listId 用户编号集合
     * @return
     */
    List<Integer> findUserRoleOnList(@Param("listId") List<String> listId);

    /**
     * 查询用户角色
     * @param userId 用户编号
     * @return
     */
    int findUserRole(@Param("userId") String userId);

    /**
     *新增用户信息
     * @param userDO 用户信息
     * @return
     */
    int addUser(UserDO userDO);

    /**
     * 删除用户信息
     * @param listId 选中的用户集合
     * @param userId 更新人
     * @return
     */
    int deleteUser(@Param("listId") List<String> listId, @Param("userId") String userId);

    /**
     * 更新用户信息
     * @param userDO 用户信息
     * @return
     */
    int updateUserById(UserDO userDO);

    /**
     * 查询用户列表(分页）
     * @param userDO 用户信息
     * @return
     */
    List<UserVO> listUserByPage(UserDO userDO);

    /**
     * 查询用户详情
     * @param userId 被查询用户编号
     * @return 用户详情
     */
    UserVO findUserById(@Param("userId") String userId);

    /**
     * 顶部栏查询
     * @param userId 当前登录用户编号
     * @return
     */
    UserVO getTopOfColumn(@Param("userId") String userId);
}
