package com.ash.server.controller;


import com.ash.server.AdminUtils;
import com.ash.server.pojo.RespBean;
import com.ash.server.pojo.Shoppingcart;
import com.ash.server.pojo.UserAddress;
import com.ash.server.service.IShoppingcartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 购物车API
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/3/30 15:13
 */
@RestController
@RequestMapping("/shoppingcart")
@Api(tags = "购物车API")
public class ShoppingcartController {

    @Autowired
    private IShoppingcartService shoppingcartService;

    @ApiOperation("根据用户查看购物车")
    @GetMapping("/")
    public List<Shoppingcart> getShoppingcartByUser(){
        return shoppingcartService.getShoppingcartByUser(AdminUtils.getCurrentAdmin().getAdminId());
    }

    @ApiOperation(value = "用户添加一条购物车")
    @PostMapping("/")
    public RespBean addUserAddress(@RequestBody Shoppingcart shoppingcart){
        if (shoppingcartService.save(shoppingcart)){
            return RespBean.success("添加成功！");
        }else{
            return RespBean.error("添加失败！");
        }
    }

    @ApiOperation(value = "用户修改一条购物车")
    @PutMapping("/")
    public RespBean updateUserAddress(@RequestBody Shoppingcart shoppingcart){
        if (shoppingcartService.updateById(shoppingcart)){
            return RespBean.success("更新成功！");
        }else{
            return RespBean.error("更新失败！");
        }

    }

    @ApiOperation(value = "用户删除一条购物车")
    @DeleteMapping("/")
    public RespBean deleteUserAddress(@RequestBody Shoppingcart shoppingcart){
        if (shoppingcartService.removeById(shoppingcart)){
            return RespBean.success("删除成功！");
        }else{
            return RespBean.error("删除失败！");
        }
    }
}
