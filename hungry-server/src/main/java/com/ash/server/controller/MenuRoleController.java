package com.ash.server.controller;


import com.ash.server.pojo.MenuRole;
import com.ash.server.pojo.RespBean;
import com.ash.server.service.IMenuRoleService;
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
 * 角色菜单管理API
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/4/11 15:24
 */
@RestController
@RequestMapping("/menuRole")
@ApiSupport(order = 6)
@Api(tags = "角色菜单管理API")
public class MenuRoleController {

    @Autowired
    private IMenuRoleService menuRoleService;

    @ApiOperation(value = "根据角色 id 查询菜单 id")
    @GetMapping("/mid/{roleId}")
    public List<Integer> getMidByRid(@PathVariable Integer roleId) {
        return menuRoleService.list(new QueryWrapper<MenuRole>()
                .eq("role_id", roleId))
                .stream().map(MenuRole::getMenuId)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "更新角色菜单")
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        return menuRoleService.updateMenuRole(rid, mids);
    }
}
