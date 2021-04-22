package com.ash.server.controller;


import com.ash.server.pojo.Menu;
import com.ash.server.pojo.MenuRole;
import com.ash.server.pojo.RespBean;
import com.ash.server.service.IMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单管理API
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/4/10 22:55
 */
@RestController
@RequestMapping("/system/cfg")
@ApiSupport(order = 4)
@Api(tags = "菜单管理API")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @ApiOperation(value = "通过用户id查询菜单列表")
    @GetMapping("/menu")
    public List<Menu>getMenusByAdminId(){
        return menuService.getMenusByAdminId();
    }

    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }




}
