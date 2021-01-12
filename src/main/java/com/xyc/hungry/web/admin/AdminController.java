package com.xyc.hungry.web.admin;

import com.xyc.hungry.model.Admin;
import com.xyc.hungry.service.AdminService;
import com.xyc.hungry.util.MD5Utils;
import com.xyc.hungry.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: hungry-main
 * @description:
 * @author: ash
 * @create: 2021/01/12 21:23
 */
@RestController
@RequestMapping("/admin")
@Api(tags="1-管理员处理")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation("管理员登录")
    @PostMapping("/login")
    public Msg loginAdmin(@ApiParam("管理员账号")@RequestParam("username") String username,
                          @ApiParam("管理员密码")@RequestParam("password") String password) {
        Msg msg=new Msg();
        Map<String,Object> map=new HashMap<>();
        Admin admin=adminService.findAdminByUserNameAndPassword(username, MD5Utils.stringToMD5(password));
        if(admin!=null)
        {
            //session.setAttribute("admin",admin);
            map.put("access_token",MD5Utils.stringToMD5(admin.getAdminId()+admin.getAdminUsername()+System.currentTimeMillis()));
            map.put("AdminUsername",admin.getAdminUsername());
            msg.setData(map);
            System.out.println("用户 "+username+" 成功登陆！");
            System.out.println("用户凭证access_token: "+map.get("access_token"));
            System.out.println(msg);
            return msg;
        }
        return Msg.success();
    }

}
