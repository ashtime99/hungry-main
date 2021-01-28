package com.ash.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("h_commodity")
@ApiModel(value="Commodity对象", description="")
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    private Integer commodityId;

    @ApiModelProperty(value = "商品分类id")
    private String commodityCategoryId;

    @ApiModelProperty(value = "图片id")
    private Integer imageId;

    @ApiModelProperty(value = "商品名称")
    private String commodityName;

    @ApiModelProperty(value = "商品库存")
    private String commodityStock;

    @ApiModelProperty(value = "商品价格 ")
    private BigDecimal commodityPrice;

    @ApiModelProperty(value = "商品折扣")
    private String commodityDiscount;

    @ApiModelProperty(value = "商品描述")
    private String commodityDescribe;

    @ApiModelProperty(value = "商品冻结状态（默认0，0-正常，1-冻结）")
    private Boolean commodityLocked;

    @ApiModelProperty(value = "商品删除状态（默认0，0-正常，1-删除）")
    private Boolean commodityEnable;

    @ApiModelProperty(value = "商品创建时间")
    private LocalDateTime commodityCreateTime;

    @ApiModelProperty(value = "商品最近修改时间")
    private LocalDateTime commodityUpdateTime;


}
