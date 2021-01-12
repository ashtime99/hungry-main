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
@RequestMapping("/page")
@Api(tags="0-页面处理")
public class PageController {


    @ApiOperation("跳转到主页面")
    @GetMapping("/adminIndex")
    public String indexPage()
    {
        return "views/index";
    }

    @ApiOperation("跳转到登录页面")
    @GetMapping("/adminLogin")
    public String adminLogin(Model model)
    {
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "views/user/login";
    }

    @ApiOperation("跳转到注册页面")
    @GetMapping("/adminReg")
    public String adminReg()
    {
        return "views/user/reg";
    }

    @ApiOperation("跳转到控制台页面")
    @GetMapping("/adminConsole")
    public String ConsolePage()
    {
        return "views/home/console";
    }

}
