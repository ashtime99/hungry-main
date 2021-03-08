package com.ash.server.controller;


import com.ash.server.pojo.Menu;
import com.ash.server.pojo.MenuRole;
import com.ash.server.pojo.RespBean;
import com.ash.server.pojo.Role;
import com.ash.server.service.IMenuRoleService;
import com.ash.server.service.IMenuService;
import com.ash.server.service.IRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 权限组-角色
 * @Author ash
 * @Date 2021/3/5 16:33
 * @Version 1.0
 */
@RestController
@RequestMapping("/system/basic/permission")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IMenuRoleService menuRoleService;

    @ApiOperation(value = "获取所有角色")
    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.list();
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role) {
        if (!role.getRoleName().startsWith("ROLE_")) {
            role.setRoleName("ROLE_" + role.getRoleName());
        }
        if (roleService.save(role)) {
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/role/{rid}")
    public RespBean deleteRole(@PathVariable Integer rid) {
        if (roleService.removeById(rid)) {
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

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
