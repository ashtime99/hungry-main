package com.ash.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

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
@TableName("h_order_detailed")
@ApiModel(value="OrderDetailed对象", description="")
public class OrderDetailed implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单子id")
    @TableId(value = "order_detailed_id", type = IdType.AUTO)
    private Integer orderDetailedId;

    @ApiModelProperty(value = "订单id")
    private Long orderId;

    @ApiModelProperty(value = "商品id")
    private Long commodityId;

    @ApiModelProperty(value = "订单数量")
    private Integer orderDetailedNum;

    @ApiModelProperty(value = "订单详情单价")
    private BigDecimal orderDetailedPrice;

    @ApiModelProperty(value = "订单详情总价")
    private BigDecimal orderDetailedTotal;

//    @ApiModelProperty(value = "订单")
//    @TableField(exist = false)
//    private Order order;

    @ApiModelProperty(value = "商品")
    @TableField(exist = false)
    private Commodity commodity;

    @ApiModelProperty(value = "商品图片")
    @TableField(exist = false)
    private String commodityImage;

    @ApiModelProperty(value = "商品名称")
    @TableField(exist = false)
    private String commodityName;



}
