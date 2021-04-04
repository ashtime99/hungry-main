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

/**
 * <p>
 * 
 * </p>
 *
 * @author ash
 * @since 2021-03-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("h_commodity_spec")
@ApiModel(value="CommoditySpec对象", description="")
public class CommoditySpec implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品规格id")
    @TableId(value = "commodity_category_id", type = IdType.AUTO)
    private Integer commoditySpecId;

    @ApiModelProperty(value = "商品id")
    private Integer commodityId;

    @ApiModelProperty(value = "商品规格id")
    private Integer categoryId;

    @ApiModelProperty(value = "商品")
    @TableField(exist = false)
    private Commodity commodity;

    @ApiModelProperty(value = "商品类别")
    @TableField(exist = false)
    private Spec spec;
}
