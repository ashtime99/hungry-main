package com.ash.server.controller;


import com.ash.server.pojo.Admin;
import com.ash.server.pojo.RespBean;
import com.ash.server.pojo.RespPageBean;
import com.ash.server.pojo.Role;
import com.ash.server.service.IAdminService;
import com.ash.server.service.IRoleService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户管理API
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/3/29 12:06
 */
@RestController
@ApiSupport(order = 3)
@RequestMapping("/system/admin")
@Api(tags = "用户管理API")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @GetMapping("/")
    @ApiOperation(value="获取所有用户")
    @ApiImplicitParam(name = "keywords",value = "关键字")
    public List<Admin>getAllAdmins(String keywords){
        return adminService.getAllAdmins(keywords);
    }

    @ApiOperation("获取所有用户（分页）")
    @GetMapping("/all")
    public RespPageBean getAllAdminByPage(@RequestParam(defaultValue = "1")Integer currentPage,
                                        @RequestParam(defaultValue = "10")Integer size,
                                          Integer adminType,
                                          String keywords){
        return adminService.getAllAdminByPage(currentPage,size,adminType,keywords);
    }



    @PostMapping("/")
    @ApiOperation(value = "添加用户")
    public RespBean addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }


    @ApiOperation(value="更新用户")
    @PutMapping("/")
    public RespBean updateAdmin(@RequestBody Admin admin){
        if (adminService.updateById(admin)){
            return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/{adminId}")
    @ApiOperation(value="删除用户")
    @ApiImplicitParam(name = "adminId",value = "管理员id",required = true)
    public RespBean updateAdmin(@PathVariable Integer adminId){
        if (adminService.removeById(adminId)){
            return RespBean.success("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

//    @GetMapping("/roles")
//    @ApiOperation(value = "获取所有角色")
//    public List<Role> getAllRoles() {
//        return roleService.list();
//    }

    @PutMapping("/role")
    @ApiOperation(value="更新用户角色")
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
