package com.xzsd.pc.menu.dao;

import com.xzsd.pc.menu.entity.MenuDO;
import com.xzsd.pc.menu.entity.MenuVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单管理接口
 * @author WangZeBin
 * @date 2020-04-02
 */
public interface MenuDao {
    /**
     * 查询相同菜单
     * @param menuDO
     * @return
     */
    int countMenuSame(MenuDO menuDO);

    /**
     * 新增菜单
     * @param menuDO
     * @return
     */
    int addMenu(MenuDO menuDO);

    /**
     * 删除菜单
     * @param listMenuId 选中的菜单Id集合
     * @param userId 当前用户Id
     * @return
     */
    int deleteMenu(@Param("listMenuId") List<String> listMenuId, @Param("userId") String userId);

    /**
     * 修改用户信息
     * @param menuDO
     * @return
     */
    int updateMenuById(MenuDO menuDO);

    /**
     * 查询菜单信息列表
     * @param role 角色编码
     * @return
     */
    List<MenuVO> listMenu(@Param("role") int role);

    /**
     * 查询菜单详情
     * @param menuId 菜单编号
     * @return
     */
    MenuVO findMenuById(String menuId);
}
