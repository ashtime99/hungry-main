package com.xyc.hungry.web.admin;

import com.xyc.hungry.model.Admin;
import com.xyc.hungry.model.Role;
import com.xyc.hungry.service.AdminService;
import com.xyc.hungry.service.RoleService;
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
import java.util.List;
import java.util.Map;

/**
 * @program: hungry-main
 * @description:
 * @author: ash
 * @create: 2021/01/12 21:23
 */
@Controller
@RequestMapping("/admin")
@Api(tags="1-管理员处理")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @ApiOperation("显示所有权限")
    @GetMapping("/showRoleList")
    public Msg showRoleList(){
        Msg msg=new Msg();
        List<Role> roleList=roleService.selectAllRole();
        Map<String,Object> map=new HashMap<>();
        map.put("roleList",roleList);
        map.put("total",5);
        msg.setData(map);
        msg.setCode(0);
        msg.setMsg("访问成功");
        return msg;
    }


}
