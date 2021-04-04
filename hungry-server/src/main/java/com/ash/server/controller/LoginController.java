package com.ash.server.controller;

import com.ash.server.pojo.Admin;
import com.ash.server.pojo.AdminLoginParam;
import com.ash.server.pojo.RespBean;
import com.ash.server.service.IAdminService;
import com.ash.server.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @Description 登录控制器
 * @Author ash
 * @Date 2021/1/26 22:32
 * @Version 1.0
 **/
@RestController
@Api(tags = "登录API")
public class LoginController {

    @Autowired
    private IAdminService adminService;
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "管理员登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request){
        System.out.println(adminLoginParam);
        return adminService.login(adminLoginParam,request);
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/user/login")
    public RespBean userLogin(@RequestBody AdminLoginParam userLoginParam, HttpServletRequest request){
        return userService.userLogin(userLoginParam,request);
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("注销成功！");
    }

    @ApiOperation(value = "获取当前管理员信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal){
        if (null==principal){
            return null;
        }
        String username=principal.getName();
        Admin admin=adminService.getAdminByUsername(username);
        admin.setAdminPassword(null);
        admin.setRoles(adminService.getRoles(admin.getAdminId()));
        return admin;
    }
}
