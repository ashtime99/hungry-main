package com.ash.server.controller;


import com.ash.server.pojo.RespBean;
import com.ash.server.pojo.User;
import com.ash.server.pojo.UserLoginParam;
import com.ash.server.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: user
 * @Author ash
 * @Date 2021/3/4 13:47
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "用户登录")
    @GetMapping("/login")
    public User userLogin(@RequestBody UserLoginParam userLoginParam, HttpServletRequest request){
        return userService.userLogin(userLoginParam,request);
    }

    @ApiOperation(value = "显示所有用户")
    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.list();
    }

    @ApiOperation(value = "添加用户")
    @PostMapping("/")
    public RespBean addUser(@RequestBody User user){
        user.setUserCreateTime(LocalDateTime.now());
        if (userService.save(user)){
            return RespBean.success("添加成功!");
        }else{
            return RespBean.error("添加失败!");
        }
    }

    @ApiOperation(value = "根据id更新用户")
    @PutMapping("/")
    public RespBean updateUser(@RequestBody User user){
        user.setUserUpdateTime(LocalDateTime.now());
        if (userService.updateById(user)){
            return RespBean.success("更新成功!");
        }else{
            return RespBean.error("更新失败!");
        }
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
