package com.ash.server.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("h_order")
@ApiModel(value="Order对象", description="")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id")
    @TableId(value = "order_id")
    private Long orderId;

    @ApiModelProperty(value = "订单状态")
    private Integer orderStatusId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "地址id")
    private Integer addressId;

    @ApiModelProperty(value = "操作员id")
    private Integer operatorId;

    @ApiModelProperty(value = "是否配送")
    private Boolean orderDelivery;

    @ApiModelProperty(value = "配送员id")
    private Integer driverId;

    @ApiModelProperty(value = "订单总价")
    private String orderTotal;

    @ApiModelProperty(value = "订单创建时间")
    private LocalDateTime orderCreateTime;

    @ApiModelProperty(value = "订单最近修改时间")
    private LocalDateTime orderUpdateTime;

    @ApiModelProperty(value = "订单取消时间")
    private LocalDateTime orderCancelTime;

    @ApiModelProperty(value = "订单已支付时间")
    private LocalDateTime orderPaidTime;

    @ApiModelProperty(value = "订单已接单时间")
    private LocalDateTime orderReceivedTime;

    @ApiModelProperty(value = "订单已配送时间")
    private LocalDateTime orderDeliveryTime;

    @ApiModelProperty(value = "订单已完成时间")
    private LocalDateTime orderCompletedTime;

    @ApiModelProperty(value = "就餐方式")
    private Boolean orderDiningStyle;

    @ApiModelProperty(value = "订单备注")
    private String orderRemarks;


}
