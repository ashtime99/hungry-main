package com.ash.server.pojo;

import com.ash.server.converter.JsonLongSerializer;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
    @JsonSerialize(using = JsonLongSerializer.class)
    @TableId(value = "order_id")
    private Long orderId;

    @ApiModelProperty(value = "订单状态")
    private Integer orderStatus;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "地址id")
    private Long addressId;

    @ApiModelProperty(value = "操作员id")
    private Integer operatorId;

    @ApiModelProperty(value = "是否配送")
    private Boolean orderDelivery;

    @ApiModelProperty(value = "配送员id")
    private Integer driverId;

    @ApiModelProperty(value = "订单总价")
    private BigDecimal orderTotal;

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

//    @ApiModelProperty(value = "用户")
//    @TableField(exist = false)
//    private Admin admin;
    @ApiModelProperty(value = "订单备注")
    @TableField(exist = false)
    private String userName;

    @ApiModelProperty(value = "订单备注")
    @TableField(exist = false)
    private String operatorName;

    @ApiModelProperty(value = "订单备注")
    @TableField(exist = false)
    private String driverName;

    @ApiModelProperty(value = "地址")
    @TableField(exist = false)
    private UserAddress userAddress;

    @ApiModelProperty(value = "订单详情")
    @TableField(exist = false)
    private List<OrderDetailed> orderDetaileds;

    @ApiModelProperty(value = "订单状态名称")
    @TableField(exist = false)
    private String stateName;


}
