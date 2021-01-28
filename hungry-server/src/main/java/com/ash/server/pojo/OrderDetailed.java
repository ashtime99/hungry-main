package com.ash.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
    private Integer commodityId;

    @ApiModelProperty(value = "订单规格id")
    private Integer commodityCategoryId;

    @ApiModelProperty(value = "订单数量")
    private Integer orderDetailedNum;

    @ApiModelProperty(value = "订单单价")
    private BigDecimal orderDetailedPrice;


}
