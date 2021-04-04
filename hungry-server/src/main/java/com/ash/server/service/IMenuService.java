package com.ash.server.service;

import com.ash.server.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ash
 * @since 2021-01-26
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
     * @param
     * @return java.util.List<com.ash.server.pojo.Menu>
     * @author ash
     */
    List<Menu> getAllMenus();

    /**
     * 根据用户显示菜单
     *
     * @param
     * @return java.util.List<com.ash.server.pojo.Menu>
     * @author ash
     */
    List<Menu> getMenusByUser();
}
