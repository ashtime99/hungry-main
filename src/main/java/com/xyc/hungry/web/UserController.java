package com.xyc.hungry.web;

import com.xyc.hungry.model.User;
import com.xyc.hungry.service.UserService;
import com.xyc.hungry.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: hungry
 * @description:
 * @author: ash
 * @create: 2021/01/10 19:52
 */
@RestController
@Api(tags="1-用户处理")
@RequestMapping(value = "/user",produces = "application/json; charset=utf-8")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("用户登录")
    @GetMapping("/login")
    public Msg userLogin(
            @ApiParam("用户账号")@RequestParam("username") String username,
            @ApiParam("用户密码")@RequestParam("password") String password){
        User user=userService.userLogin(username,password);
        Map<String,Object>map=new HashMap<>();
        map.put("user",user);
        Msg msg=new Msg();
        msg.setData(map);
        msg.setMsg("登录成功");
        userService.updateUserById(user);
        if (user!=null){
            return msg;
        }else {
            return Msg.fail();
        }
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Msg userRegister(
            @ApiParam("用户账号")@Param("username") String username,
            @ApiParam("用户密码")@Param("password") String password){
        User user=new User();
        user.setUserUsername(username);
        user.setUserUsername(password);
        int row=userService.userRegister(user);
        Msg msg=new Msg();
        if (row!=0){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }


}
