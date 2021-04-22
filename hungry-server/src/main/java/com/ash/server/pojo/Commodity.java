package com.ash.server.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@TableName("h_commodity")
@ApiModel(value="Commodity对象", description="")
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    @TableId(value = "commodity_id", type = IdType.AUTO)
    private Integer commodityId;

    @ApiModelProperty(value = "商品分类id")
    private Integer categoryId;

    @ApiModelProperty(value = "商品图片")
    private String commodityImage;

    @ApiModelProperty(value = "商品名称")
    @Excel(name = "商品名称")
    private String commodityName;

    @ApiModelProperty(value = "商品价格")
    @Excel(name = "商品价格")
    private BigDecimal commodityPrice;

    @ApiModelProperty(value = "商品库存")
    @Excel(name = "商品库存")
    private Integer commodityStock;

    @ApiModelProperty(value = "商品折扣")
    private String commodityDiscount;

    @ApiModelProperty(value = "商品描述")
    @Excel(name = "商品分类")
    private String commodityDescribe;

    @ApiModelProperty(value = "商品冻结状态（默认0，0-正常，1-冻结）")
    private Boolean commodityLocked;

    @ApiModelProperty(value = "商品删除状态（默认0，0-正常，1-删除）")
    private Boolean commodityEnable;

    @ApiModelProperty(value = "商品创建时间")
    @Excel(name = "商品创建时间",width = 10,timezone = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime commodityCreateTime;

    @ApiModelProperty(value = "商品最近修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime commodityUpdateTime;

    @ApiModelProperty(value = "类别")
    @TableField(exist = false)
    @ExcelEntity(name = "商品分类")
    private Category category;



}
