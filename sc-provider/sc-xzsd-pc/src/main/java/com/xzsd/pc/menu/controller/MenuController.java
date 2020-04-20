package com.xzsd.pc.menu.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.menu.entity.MenuDO;
import com.xzsd.pc.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 菜单增删改查
 * @author WangZeBin
 * @date 2020-04-02
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(MenuController.class);

    @Resource
    MenuService menuService;

    /**
     * 新增菜单
     * @param menuDO 菜单信息
     * @return
     * @author WangZeBin
     * @date 2020-04-02
     */
    @PostMapping("/addMenu")
    public AppResponse addMenu(MenuDO menuDO) {
        try {
            //获取用户Id
            String userId = SecurityUtils.getCurrentUserId();
            menuDO.setCreateBy(userId);
            return menuService.addMenu(menuDO);
        } catch (Exception e) {
            logger.error("菜单新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除菜单
     * @param menuId 菜单Id
     * @return
     * @author WangZeBin
     * @date 2020-04-02
     */
    @PostMapping("/deleteMenu")
    public AppResponse deleteMenu(String menuId) {
        try {
            //获取用户Id
            String userId = SecurityUtils.getCurrentUserId();
            return menuService.deleteMenu(menuId,userId);
        } catch (Exception e) {
            logger.error("菜单删除失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改菜单信息
     * @param menuDO 菜单信息
     * @return
     * @author WangZeBin
     * @date 2020-04-02
     */
    @PostMapping("updateMenuById")
    public AppResponse updateMenuById(MenuDO menuDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            menuDO.setModifyBy(userId);
            return menuService.updateMenuById(menuDO);
        } catch (Exception e) {
            logger.error("修改菜单信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询菜单列表
     * @param role 用户角色编号
     * @return
     * @author WangZeBin
     * @date 2020-04-02
     */
    @RequestMapping(value="listMenu")
    public AppResponse listMenu(int role) {
        try {
            return menuService.listMenu(role);
        } catch(Exception e) {
            logger.error("查询菜单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询菜单详情
     * @param menuId 选中的编号
     * @return
     * @author WangZeBin
     * @date 2020-04-02
     */
    @RequestMapping(value="findMenuById")
    public AppResponse findMenuById(String menuId) {
        try {
            return menuService.findMenuById(menuId);
        } catch (Exception e) {
            logger.error("查询c爱的详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
