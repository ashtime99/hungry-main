package com.ash.server.controller;


import com.ash.server.pojo.Admin;
import com.ash.server.pojo.RespBean;
import com.ash.server.pojo.Role;
import com.ash.server.service.IAdminService;
import com.ash.server.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 管理员前端控制器
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/3/29 12:06
 */
@RestController
@RequestMapping("/system/admin")
@Api(tags = "管理员管理API")
public class AdminController {

    @Autowired
    private IAdminService adminService;
    @Autowired
    private IRoleService roleService;


    @GetMapping("/")
    @ApiOperation(value="获取所有管理员")
    @ApiImplicitParam(name = "keywords",value = "关键字")
    public List<Admin>getAllAdmins(String keywords){
        return adminService.getAllAdmins(keywords);
    }


    @PostMapping("/")
    @ApiOperation(value = "添加管理员")
    public RespBean addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }


    @ApiOperation(value="更新管理员")
    @PutMapping("/")
    public RespBean updateAdmin(@RequestBody Admin admin){
        if (adminService.updateById(admin)){
            return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/{adminId}")
    @ApiOperation(value="删除管理员")
    @ApiImplicitParam(name = "adminId",value = "管理员id",required = true)
    public RespBean updateAdmin(@PathVariable Integer adminId){
        if (adminService.removeById(adminId)){
            return RespBean.success("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @GetMapping("/roles")
    @ApiOperation(value = "获取所有角色")
    public List<Role> getAllRoles() {
        return roleService.list();
    }

    @PutMapping("/role")
    @ApiOperation(value="更新管理员角色")
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
