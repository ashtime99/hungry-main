package com.ash.server.controller;


import com.ash.server.pojo.*;
import com.ash.server.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 用户API
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/3/29 12:09
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户API",value = "1")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "获取当前用户信息")
    @GetMapping("/user/info")
    public User getAdminInfo(Principal principal){
        if (null==principal){
            return null;
        }
        String username=principal.getName();
        User user=userService.getUserByUsername(username);
        user.setUserPassword(null);
        //user.setRoles(adminService.getRoles(admin.getAdminId()));
        return user;
    }


    @ApiOperation(value = "显示所有用户")
    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.list();
    }

    @ApiOperation(value = "添加用户")
    @PostMapping("/")
    public RespBean addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @ApiOperation(value = "根据id更新用户")
    @PutMapping("/")
    public RespBean updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @ApiOperation(value = "根据id删除用户")
    @DeleteMapping("/{userId}")
    public RespBean deleteUser(@PathVariable Integer userId){
        if (userService.removeById(userId)){
            return RespBean.success("删除成功!");
        }else{
            return RespBean.error("删除失败!");
        }
    }

    @ApiOperation(value = "批量删除用户")
    @DeleteMapping("/")
    public RespBean deleteUserByIds(@PathVariable Integer[] userIds){
        if (userService.removeByIds(Arrays.asList(userIds))){
            return RespBean.success("删除成功!");
        }else{
            return RespBean.error("删除失败!");
        }
    }

}
