package com.ash.server.controller;


import com.ash.server.pojo.Order;
import com.ash.server.pojo.OrderDetailed;
import com.ash.server.pojo.RespPageBean;
import com.ash.server.service.IOrderDetailedService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
@RestController
@RequestMapping("/order/detailed")
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

}
