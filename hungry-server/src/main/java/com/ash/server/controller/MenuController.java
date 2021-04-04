package com.ash.server.controller;


import com.ash.server.pojo.Menu;
import com.ash.server.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
@RestController
@RequestMapping("/system/cfg")
@Api(tags = "菜单API")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @ApiOperation(value = "通过管理员id查询菜单列表")
    @GetMapping("/menu")
    public List<Menu>getMenusByAdminId(){
        return menuService.getMenusByAdminId();
    }

    @ApiOperation(value = "通过管理员id查询菜单列表")
    @GetMapping("/user/menu")
    public List<Menu>getMenusByUser(){
        return menuService.getMenusByUser();
    }

}
