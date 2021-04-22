package com.ash.server.controller;


import cn.hutool.json.JSONUtil;
import com.alipay.api.AlipayApiException;
import com.ash.server.service.ICommodityService;
import com.ash.server.util.AdminUtils;
import com.ash.server.pojo.*;
import com.ash.server.service.AlipayService;
import com.ash.server.service.IOrderDetailedService;
import com.ash.server.service.IOrderService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 订单
 * @Author ash
 * @Date 2021/3/18 10:19
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/order")
@Api(tags = "订单管理API")
public class OrderController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private ICommodityService commodityService;
    @Autowired
    private IOrderDetailedService orderDetailedService;
    @Autowired
    private AlipayService alipayService;

    @ApiOperation("显示订单（分页）")
    @GetMapping("/all")
    public RespPageBean getOrder(@RequestParam(defaultValue = "1")Integer currentPage,
                                 @RequestParam(defaultValue = "10")Integer size,
                                 Order order,
                                 LocalDate[]beginDataScope){
        return orderService.getOrderByPage(currentPage,size,order,beginDataScope);
    }

    @ApiOperation("根据用户和订单状态显示订单")
    @GetMapping("/byState")
    @ApiOperationSupport(includeParameters = {"state","orderId","orderTotal","orderCreateTime","orderDiningStyle",
            "orderRemarks","userName","operatorName","userAddress"})
    public List<Order> getOrderByState(@RequestParam Integer state){
        return orderService.getOrderByState(AdminUtils.getCurrentAdmin().getAdminId(),state);
    }

    @ApiOperation("根据操作员和订单状态显示订单")
    @GetMapping("/byOp")
    @ApiOperationSupport(includeParameters = {"state","orderId","orderTotal","orderCreateTime","orderDiningStyle",
            "orderRemarks","userName","operatorName","userAddress"})
    public List<Order> getOrderByOp(@RequestParam Integer state){
        return orderService.getOrderByOp(AdminUtils.getCurrentAdmin().getAdminId(),state);
    }

    @ApiOperation("根据操作员和订单状态显示订单")
    @GetMapping("/byDr")
    @ApiOperationSupport(includeParameters = {"state","orderId","orderTotal","orderCreateTime","orderDiningStyle",
            "orderRemarks","userName","operatorName","userAddress"})
    public List<Order> getOrderByDr(@RequestParam Integer state){
        return orderService.getOrderByDr(AdminUtils.getCurrentAdmin().getAdminId(),state);
    }

    @ApiOperation("添加订单")
    @PostMapping("/addOrder")
    @ApiOperationSupport(includeParameters = {"order.addressId","order.orderTotal","order.orderDiningStyle","order.orderRemarks",
            "order.addressId","order.orderDetaileds.commodityId","order.orderDetaileds.orderDetailedNum","order.orderDetaileds.orderDetailedPrice"})
    @Transactional
    public RespBean addOrder(@RequestBody Order order){
        order.setUserId(AdminUtils.getCurrentAdmin().getAdminId());
        order.setOrderCreateTime(LocalDateTime.now());
        order.setOrderStatus(0);
        if (orderService.save(order)&&order.getOrderDetaileds()!=null){
            List<OrderDetailed>orderDetailedList=order.getOrderDetaileds();
            orderDetailedList.stream().forEach(orderDetailed -> orderDetailed.setOrderId(order.getOrderId()));
            if (orderDetailedService.saveBatch(orderDetailedList)){
                return RespBean.success("添加成功!");
            }else{
                return RespBean.error("添加失败!");
            }
        }else return RespBean.error("添加失败!");
    }


    @ApiOperation("修改订单")
    @PutMapping("/")
    public RespBean updateOrder(@RequestBody Order order){
        if(orderService.updateById(order)){
            return RespBean.success("更新成功!");
        }else return RespBean.error("更新失败!");
    }


    @ApiOperation("支付订单")
    @GetMapping("/pay")
    @Transactional
    public void payOrder(@RequestParam Long oid,HttpServletRequest request,HttpServletResponse response) throws IOException, AlipayApiException {
        Order order=orderService.getById(oid);
        order.setOrderStatus(1);
        List<Commodity> commodities=order.getOrderDetaileds().stream()
                .map(orderDetailed -> orderDetailed.getCommodity())
                .collect(Collectors.toList());
        commodities.forEach(commodity -> commodity.setCommodityStock(commodity.getCommodityStock()-1));
        //commodityService.updateBatchById(commodities);
        log.info("修改商品库存{}",commodityService.updateBatchById(commodities));
        orderService.updateById(order);
        alipayService.aliPay(order.getOrderId(),order.getOrderTotal(),request,response);
    }

    @ApiOperation("支付成功")
    @GetMapping("/paySuccess")
    public void payOrderSuccess(@RequestParam Long oid){
        Order order=orderService.getById(oid);
        order.setOrderStatus(2);
        orderService.updateById(order);
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
