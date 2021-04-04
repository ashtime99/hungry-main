package com.ash.server.controller;


import com.ash.server.pojo.Order;
import com.ash.server.pojo.RespBean;
import com.ash.server.pojo.RespPageBean;
import com.ash.server.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @Description: 订单
 * @Author ash
 * @Date 2021/3/18 10:19
 * @Version 1.0
 */
@RestController
@RequestMapping("/order")
@Api(tags = "登录API")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @ApiOperation("显示订单（分页）")
    @GetMapping("/all")
    public RespPageBean getOrder(@RequestParam(defaultValue = "1")Integer currentPage,
                                 @RequestParam(defaultValue = "10")Integer size,
                                 Order order,
                                 LocalDate[]beginDataScope){
        return orderService.getOrderByPage(currentPage,size,order,beginDataScope);
    }

    @ApiOperation("修改订单")
    @GetMapping("/")
    public RespBean updateOrder(@RequestBody Order order){
        if(orderService.updateById(order)){
            return RespBean.success("更新成功!");
        }else return RespBean.error("更新失败!");
    }

//
//    @ApiOperation("删除订单")
//    @GetMapping("/")
//    public List<Order> getAllOrder(){
//        return null;
//    }
//
//    @ApiOperation("查询订单")
//    @GetMapping("/")
//    public List<Order> getAllOrder(){
//        return null;
//    }
}
