package com.ash.server.mapper;

import com.ash.server.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */

@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    /** 
     * @Description: 通过管理员id查询菜单列表 
     * @Param: [adminId] 
     * @Return: java.util.List<com.ash.server.pojo.Menu> 
     * @Author ash
     * @Date: 17:40 2021/1/30
     */ 
    List<Menu> getMenusByAdminId(Long adminId);

    /**
     * @Description: 根据角色获取菜单列表 
     * @Param: [] 
     * @Return: java.util.List<com.ash.server.pojo.Menu> 
     * @Author ash
     * @Date: 16:36 2021/2/4
     */ 
    List<Menu> getMenusWithRole();

    /** 
     * @Description: 查询所有菜单 
     * @Param: [] 
     * @Return: java.util.List<com.ash.server.pojo.Menu> 
     * @Author ash
     * @Date: 17:12 2021/3/5
     */ 
    List<Menu> getAllMenus();
}
