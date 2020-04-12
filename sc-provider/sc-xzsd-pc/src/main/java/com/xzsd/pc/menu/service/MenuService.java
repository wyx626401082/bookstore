package com.xzsd.pc.menu.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.menu.entity.MenuDO;
import com.xzsd.pc.menu.entity.MenuVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * 菜单管理实现类
 * @author WangZeBin
 * @date 2020-04-02
 */
@Service
public class MenuService {
    @Resource
    MenuDao menuDao;

    /**
     * 新增菜单
     * @param menuDO 菜单新信息
     * @return
     * @author WangZeBin
     * @date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMenu(MenuDO menuDO) {
        AppResponse appResponse = AppResponse.success("新增菜单成功！");
        //检测菜单是否存在
//        int countSame = menuDao.countMenuSame(menuDO);
//        if(0 != countSame) {
//            appResponse = AppResponse.success("菜单已存在，请重新输入");
//        }
        //新增菜单
        int count = menuDao.addMenu(menuDO);
        if(0 == count) {
            appResponse = AppResponse.bizError("新增菜单失败");
        }
        return appResponse;
    }

    /**
     * 删除菜单
     * @param menuId 选中菜单Id
     * @param userId 当前用户Id
     * @return
     * @author WangZeBin
     * @date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMenu(String menuId,String userId) {
        List<String> listMenuId = Arrays.asList(menuId.split(","));
        AppResponse appResponse = AppResponse.success("删除菜单成功！");
        int count = menuDao.deleteMenu(listMenuId,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除菜单失败");
        }
        return appResponse;
    }

    /**
     * 修改用户信息
     * @param menuDO 菜单新信息
     * @return
     * @author WangZeBin
     * @date 2020-04-02
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateMenuById(MenuDO menuDO) {
        AppResponse appResponse = AppResponse.success("菜单修改成功！");
        int countMenuSame = menuDao.countMenuSame(menuDO);
        if(0 != countMenuSame) {
            return AppResponse.success("菜单已存在，请重新输入！");
        }
        //修改菜单信息
        int count = menuDao.updateMenuById(menuDO);
        if(0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 查询菜单列表
     * @return
     * @author WangZeBin
     * @date 2020-04-02
     */
    public AppResponse listMenu() {
        List<MenuVO> menuVOList = menuDao.listMenu();
        return AppResponse.success("查询菜单列表成功！", menuVOList);
    }

    /**
     * 查询用户详情
     * @param menuId 选中菜单编号
     * @return
     * @author WangZeBin
     * @date 2020-04-02
     */
    public AppResponse findMenuById(String menuId) {
        MenuVO menuVO = null;
        menuVO = menuDao.findMenuById(menuId);
        if (menuVO == null) {
            return AppResponse.notFound("无查询结果");
        }
        return AppResponse.success("查询菜单详情成功", menuVO);
    }
}
