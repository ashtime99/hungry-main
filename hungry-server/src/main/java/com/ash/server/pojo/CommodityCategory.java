package com.ash.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@TableName("h_commodity_category")
@ApiModel(value="CommodityCategory对象", description="")
public class CommodityCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品规格id")
    @TableId(value = "commodity_category_id", type = IdType.AUTO)
    private Integer commodityCategoryId;

    @ApiModelProperty(value = "商品id")
    private Integer commodityId;

    @ApiModelProperty(value = "父商品规格id")
    private String commodityCategoryParentId;

    @ApiModelProperty(value = "商品规格名称")
    private String commodityCategoryName;

    @ApiModelProperty(value = "商品规格删除状态")
    private Boolean commodityCategoryDelete;

    @ApiModelProperty(value = "商品规格创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime commodityCategoryCreateTime;

    @ApiModelProperty(value = "商品规格最近修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime commodityCategoryUpdateTime;


}
