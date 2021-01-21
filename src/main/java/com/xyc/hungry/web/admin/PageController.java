package com.xyc.hungry.web.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

//页面跳转对应的控制层
@Controller
@RequestMapping("/backstage")
@Api(tags="0-页面处理")
public class PageController {


    @ApiOperation("跳转到管理员登录页面")
    @GetMapping("/login")
    public String adminToLogin(Model model)
    {
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "views/user/login";
    }

    @ApiOperation("跳转到主页面")
    @GetMapping("/index")
    public String indexPage()
    {
        return "views/index";
    }

    @ApiOperation("跳转到控制台页面")
    @GetMapping("/console")
    public String consolePage()
    {
        return "views/home/console";
    }

    @ApiOperation("跳转到人员列表页面")
    @GetMapping("/adminList")
    public String adminListPage()
    {
        return "views/table/adminTable";
    }

    @ApiOperation("跳转到权限列表页面")
    @GetMapping("/roleList")
    public String roleListPage()
    {
        return "views/table/roleTable";
    }

}
