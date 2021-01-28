package com.ash.server.pojo;

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
@TableName("h_shoppingcart")
@ApiModel(value="Shoppingcart对象", description="")
public class Shoppingcart implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "购物车id")
    private Integer shoppingcartId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "商品id")
    private Integer commodityId;

    @ApiModelProperty(value = "购物车数量")
    private Integer shoppingcartNum;

    @ApiModelProperty(value = "购物车删除状态")
    private Boolean shoppingcartDelete;

    @ApiModelProperty(value = "购物车创建时间")
    private LocalDateTime shoppingcartCreateTime;

    @ApiModelProperty(value = "购物车最近修改时间")
    private LocalDateTime shoppingcartUpdateTime;


}
