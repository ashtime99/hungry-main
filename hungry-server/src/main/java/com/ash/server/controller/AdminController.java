package com.ash.server.controller;


import com.ash.server.pojo.Admin;
import com.ash.server.pojo.RespBean;
import com.ash.server.pojo.Role;
import com.ash.server.service.IAdminService;
import com.ash.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/system/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;
    @Autowired
    private IRoleService roleService;

    @ApiOperation(value="获取所有操作员")
    @GetMapping("/")
    public List<Admin>getAllAdmins(String keywords){
        return adminService.getAllAdmins(keywords);
    }


    @ApiOperation(value="更新操作员")
    @PutMapping("/")
    public RespBean updateAdmin(@RequestBody Admin admin){
        if (adminService.updateById(admin)){
            return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @ApiOperation(value="删除操作员")
    @DeleteMapping("/{adminId}")
    public RespBean updateAdmin(@PathVariable Integer adminId){
        if (adminService.removeById(adminId)){
            return RespBean.success("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @ApiOperation(value = "获取所有角色")
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.list();
    }

    @ApiOperation(value="更新操作员角色")
    @PutMapping("/role")
    public RespBean updateAdminRole(Integer adminId,Integer[] roleIds){
        return adminService.updateAdminRole(adminId,roleIds);
    }

//    @ApiOperation(value="批量删除操作员")
//    @DeleteMapping("/{adminIds}")
//    public RespBean updateAdmin(@PathVariable Integer[] adminIds){
//        if (adminService.removeByIds(adminIds)){
//            return RespBean.success("删除成功!");
//        }
//        return RespBean.error("删除失败!");
//    }
}
