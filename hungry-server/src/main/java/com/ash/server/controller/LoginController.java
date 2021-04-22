package com.ash.server.controller;

import com.ash.server.util.AdminUtils;
import com.ash.server.pojo.Admin;
import com.ash.server.pojo.AdminLoginParam;
import com.ash.server.pojo.RespBean;
import com.ash.server.service.IAdminService;
import com.ash.server.service.IUserService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户登录管理API
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/4/10 22:07
 */
@RestController
@ApiSupport(order = 1)
@Api(tags = "用户登录管理API")
public class LoginController {

    @Autowired
    private IAdminService adminService;
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "获取当前用户信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(){
        if (null== AdminUtils.getCurrentAdmin()){
            return null;
        }
        Admin admin=AdminUtils.getCurrentAdmin();
        admin.setAdminPassword(null);
        admin.setRoles(adminService.getRoles(admin.getAdminId()));
        return admin;
    }

    @ApiOperation(value = "管理员登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request){
        return adminService.login(adminLoginParam,request);
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("注销成功！");
    }
}
