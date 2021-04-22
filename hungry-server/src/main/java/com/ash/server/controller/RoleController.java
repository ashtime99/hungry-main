package com.ash.server.controller;


import com.ash.server.pojo.Menu;
import com.ash.server.pojo.MenuRole;
import com.ash.server.pojo.RespBean;
import com.ash.server.pojo.Role;
import com.ash.server.service.IMenuRoleService;
import com.ash.server.service.IMenuService;
import com.ash.server.service.IRoleService;
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
 * 角色权限管理API
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/3/30 15:13
 */
@RestController
@ApiSupport(order = 5)
@RequestMapping("/system/basic/permission")
@Api(tags = "角色权限管理API")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IMenuService menuService;


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

}
