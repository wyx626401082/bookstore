package com.xzsd.pc.user.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserDO;
import com.xzsd.pc.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 增删改查
 * @author WangZeBin
 * @date 2020-03-25
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * 新增用户
     * @param userDO 用户信息
     * @return
     * @author WangZeBin
     * @date 2020-03-25
     */
    @PostMapping("addUser")
    public AppResponse addrUser(UserDO userDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userDO.setCreateBy(userId);
            AppResponse appResponse = userService.addUser(userDO);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除用户信息
     * @param userId 选中的用户
     * @return
     * @author WangZeBin
     * @date 2020-03-26
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(String userId) {
        try {
            //获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return userService.deleteUser(userId, userCode);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改用户信息
     * @param userDO 用户信息
     * @return
     * @author WangZeBin
     * @date 2020-03-26
     */
    @PostMapping("updateUserById")
    public AppResponse updateUserById(UserDO userDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userDO.setModifyBy(userId);
            return userService.updateUserById(userDO);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询用户列表
     * @param userDO
     * @return
     * @author WangZeBin
     * @date 2020-03-27
     */
    @RequestMapping(value="listUser")
    public AppResponse listUser(UserDO userDO) {
        try {
            return userService.listUser(userDO);
        } catch(Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询用户详情
     * @param userId 被查询用户编号
     * @return
     * @author WangZeBin
     * @date 2020-03-27
     */
    @RequestMapping(value="findUserById")
    public AppResponse findUserById(String userId) {
        try {
            return userService.findUserById(userId);
        } catch (Exception e) {
            logger.error("查询用户详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
