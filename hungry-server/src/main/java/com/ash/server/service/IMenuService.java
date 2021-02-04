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
     * @Description: 通过管理员id查询菜单列表 
     * @Param: [] 
     * @Return: java.util.List<com.ash.server.pojo.Menu> 
     * @Author ash
     * @Date: 17:29 2021/1/30
     */ 
    List<Menu> getMenusByAdminId();

    /** 
     * @Description: 根据角色获取菜单列表
     * @Param: [] 
     * @Return: java.util.List<com.ash.server.pojo.Menu> 
     * @Author ash
     * @Date: 16:33 2021/2/4
     */ 
    List<Menu> getMenusWithRole();
}
