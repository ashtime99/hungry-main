package com.xyc.hungry.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: hungry
 * @description: Order 订单
 * @author: ash
 * @create: 2021/01/09 16:48
 */
@Data
@TableName("order")
public class Order {

    @TableId("order_id") //订单id
    private Long orderId;

    @TableField("user_id") //用户id
    private Integer userId;

    @TableField("address_id") //地址id
    private Integer addressId;

    @TableField("shop_id") //商铺id
    private Integer shopId;

    @TableField("order_state") //订单状态（0-已取消，1-待支付，2-已支付，3-已接单，4-已配送，5-已完成）
    private Byte orderState;

    @TableField("order_total") //订单总价
    private Double orderTotal;

    @TableField("order_create_time") //订单创建时间
    private LocalDateTime orderCreateTime;

    @TableField("order_update_time") //订单最近修改时间
    private LocalDateTime orderUpdateTime;

    @TableField("order_cancel_time") //订单取消时间
    private LocalDateTime orderCancelTime;

    @TableField("order_paid_time") //订单已支付时间
    private LocalDateTime orderPaidTime;

    @TableField("order_received_time") //订单已接单时间
    private LocalDateTime orderReceivedTime;

    @TableField("order_delivery_time") //订单已配送时间
    private LocalDateTime orderDeliveryTime;

    @TableField("order_completed_time") //订单已完成时间
    private LocalDateTime orderCompletedTime;
}
