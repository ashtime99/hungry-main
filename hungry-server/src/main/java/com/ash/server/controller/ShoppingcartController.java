package com.ash.server.controller;


import com.ash.server.util.AdminUtils;
import com.ash.server.pojo.RespBean;
import com.ash.server.pojo.Shoppingcart;
import com.ash.server.service.IShoppingcartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 购物车管理API
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/3/30 15:13
 */
@RestController
@RequestMapping("/shoppingcart")
@Api(tags = "购物车管理API")
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
    public RespBean addShoppingcart(@RequestBody Shoppingcart shoppingcart){
        shoppingcart.setShoppingcartNum(1);
        shoppingcart.setUserId(AdminUtils.getCurrentAdmin().getAdminId());
        shoppingcart.setShoppingcartCreateTime(LocalDateTime.now());
        shoppingcart.setShoppingcartUpdateTime(LocalDateTime.now());
        return shoppingcartService.addShoppingcart(shoppingcart);
//        if (shoppingcartService.save(shoppingcart)){
//            return RespBean.success("添加购物车成功！");
//        }else{
//            return RespBean.error("添加购物车失败！");
//        }
    }

    @ApiOperation(value = "用户修改一条购物车")
    @PutMapping("/")
    public RespBean updateShoppingcart(@RequestBody Shoppingcart shoppingcart){
        if (shoppingcartService.updateById(shoppingcart)){
            return RespBean.success("更新成功！");
        }else{
            return RespBean.error("更新失败！");
        }

    }

    @ApiOperation(value = "用户删除一条购物车")
    @DeleteMapping("/{id}")
    public RespBean deleteUserShoppingcart(@PathVariable Long id){
        if (shoppingcartService.removeById(id)){
            return RespBean.success("删除成功！");
        }else{
            return RespBean.error("删除失败！");
        }
    }

    @ApiOperation(value = "用户批量删除购物车")
    @DeleteMapping("/")
    public RespBean deleteUserShoppingcart(@RequestBody Long[] ids){
        if (shoppingcartService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("批量删除成功！");
        }else{
            return RespBean.error("批量删除失败！");
        }
    }
}
