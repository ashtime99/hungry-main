package com.ash.server.service;

import com.ash.server.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单业务类
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/4/4 15:24
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 通过管理员id查询菜单列表
     *
     * @return java.util.List<com.ash.server.pojo.Menu>
     * @author ash
     */
    List<Menu> getMenusByAdminId();

    /**
     * 根据角色获取菜单列表
     *
     * @return java.util.List<com.ash.server.pojo.Menu>
     * @author ash
     */
    List<Menu> getMenusWithRole();

    /**
     * 查询所有菜单
     *
     * @return java.util.List<com.ash.server.pojo.Menu>
     * @author ash
     */
    List<Menu> getAllMenus();
}
