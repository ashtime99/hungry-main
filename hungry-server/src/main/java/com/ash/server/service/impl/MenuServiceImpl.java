package com.ash.server.service.impl;

import com.ash.server.mapper.MenuMapper;
import com.ash.server.pojo.Admin;
import com.ash.server.pojo.Menu;
import com.ash.server.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisTemplate<String,Object>redisTemplate;

    /** 
     * @Description: 通过管理员id查询菜单列表
     * @Param: [] 
     * @Return: java.util.List<com.ash.server.pojo.Menu> 
     * @Author ash
     * @Date: 17:29 2021/1/30
     */ 
    @Override
    public List<Menu> getMenusByAdminId() {
        Integer adminId=((Admin)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAdminId();
        ValueOperations<String,Object>valueOperations=redisTemplate.opsForValue();
        //从redis获取菜单数据
        List<Menu>menus=(List<Menu>)valueOperations.get("menu_"+adminId);
        //如果为空，去数据库获取
        if (CollectionUtils.isEmpty(menus)){
            menus=menuMapper.getMenusByAdminId(adminId);
            //添加到redis
            valueOperations.set("menu_"+adminId,menus);
        }
        return menus;
    }

    /**
     * @Description: 根据角色获取菜单列表 
     * @Param: [] 
     * @Return: java.util.List<com.ash.server.pojo.Menu> 
     * @Author ash
     * @Date: 16:34 2021/2/4
     */ 
    @Override
    public List<Menu> getMenusWithRole() {
        return menuMapper.getMenusWithRole();
    }
}
