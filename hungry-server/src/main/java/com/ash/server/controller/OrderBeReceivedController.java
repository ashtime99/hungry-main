package com.ash.server.controller;

import com.ash.server.pojo.Order;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description: 待接收的订单
 * @Author ash
 * @Date 2021/3/15 15:19
 * @Version 1.0
 */
@RequestMapping("/order/beReceived/")
public class OrderBeReceivedController {

    @ApiOperation("显示所有的待接收订单")
    @GetMapping("/")
    public List<Order>getAllOrder(){
        return null;
    }

//
//    @ApiOperation("接收待接收订单")
//    @GetMapping("/")
//    public List<Order>getAllOrder(){
//        return null;
//    }

//    @ApiOperation("显示所有的待接收订单")
//    @GetMapping("/")
//    public List<Order>getAllOrder(){
//        return null;
//    }

}
