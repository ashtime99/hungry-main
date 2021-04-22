package com.ash.server.controller;


import com.ash.server.pojo.Order;
import com.ash.server.pojo.OrderDetailed;
import com.ash.server.pojo.RespPageBean;
import com.ash.server.service.IOrderDetailedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 订单详情API
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/4/11 19:34
 */
@RestController
@RequestMapping("/order/detailed")
@Api(tags = "订单详情API")
public class OrderDetailedController {

    @Autowired
    private IOrderDetailedService orderDetailedService;

    @ApiOperation("显示订单详情（分页）")
    @GetMapping("/")
    public RespPageBean getOrder(@RequestParam(defaultValue = "1")Integer currentPage,
                                 @RequestParam(defaultValue = "10")Integer size,
                                 OrderDetailed orderDetailed){
        return orderDetailedService.getOrderDetailedByPage(currentPage,size,orderDetailed);
    }

    @ApiOperation("根据订单号显示详情")
    @GetMapping("/orderId={orderId}")
    public List<OrderDetailed>getOrderDetailedByOrderId(@PathVariable Integer orderId){
        return orderDetailedService.getOrderDetailedByOrderId(orderId);
    }

}
