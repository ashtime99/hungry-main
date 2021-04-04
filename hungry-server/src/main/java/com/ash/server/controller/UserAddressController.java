package com.ash.server.controller;


import com.ash.server.pojo.RespBean;
import com.ash.server.pojo.UserAddress;
import com.ash.server.service.IUserAddressService;
import com.ash.server.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户地址API
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/3/29 12:09
 */
@RestController
@RequestMapping("/address")
@Api(tags = "用户地址API")
public class UserAddressController {

    @Autowired
    private IUserAddressService userAddressService;

    @ApiOperation(value = "显示该用户所有地址")
    @GetMapping("/")
    public List<UserAddress>getUserAddress(@RequestParam Integer userId){
        return userAddressService.getUserAddress(userId);
    }


    @ApiOperation(value = "用户添加地址")
    @PostMapping("/")
    public RespBean addUserAddress(@RequestParam Integer userId,@RequestBody UserAddress userAddress){
        userAddress.setUserId(userId);
        if (userAddressService.save(userAddress)){
            return RespBean.success("添加成功！");
        }else{
            return RespBean.error("添加失败！");
        }
    }

    @ApiOperation(value = "用户修改地址")
    @PutMapping("/")
    public RespBean updateUserAddress(@RequestParam Integer userId,@RequestBody UserAddress userAddress){
        userAddress.setUserId(userId);
        if (userAddressService.updateById(userAddress)){
            return RespBean.success("更新成功！");
        }else{
            return RespBean.error("更新失败！");
        }

    }

    @ApiOperation(value = "用户删除地址")
    @DeleteMapping("/")
    public RespBean deleteUserAddress(@RequestBody UserAddress userAddress){
        if (userAddressService.removeById(userAddress)){
            return RespBean.success("删除成功！");
        }else{
            return RespBean.error("删除失败！");
        }
    }




}
