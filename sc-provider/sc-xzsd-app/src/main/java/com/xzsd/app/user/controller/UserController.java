package com.xzsd.app.user.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.user.entity.UserDO;
import com.xzsd.app.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 公用部分用户信息管理
 * @author WangZeBin
 * @date 2020-04-19
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    @Resource
    UserService userService;

    /**
     * 查询当前登录用户信息
     * @return
     * @author WangZeBin
     * @date 2020-04-19
     */
    @RequestMapping(value="findUserInformation")
    public AppResponse findUserInformation() {
        try {
            //获取当前用户编号
            String userId = SecurityUtils.getCurrentUserId();
            return userService.findUserInformation(userId);
        } catch (Exception e) {
            logger.error("当前登录用户信息查询异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改用户密码
     * @param userDO
     * @return
     * @author WangZeBin
     * @date 2020-04-19
     */
    @PostMapping("updatePassword")
    public AppResponse updatePassword(UserDO userDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userDO.setUserId(userId);
            return userService.updatePassword(userDO);
        } catch (Exception e) {
            logger.error("修改密码错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
