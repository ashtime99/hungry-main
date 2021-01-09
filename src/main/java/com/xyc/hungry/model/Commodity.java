package com.xyc.hungry.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: hungry
 * @description: Commodity 商品
 * @author: ash
 * @create: 2020/12/17 22:00
 */
@Data
@TableName("commodity")
public class Commodity {

    @TableId("commodity_id") //商品id
    private Integer commodityId;

    @TableField("image_id") //商品状态
    private Integer imageId;

    @TableField("shop_id") //商品状态
    private Integer shopId;

    @TableField("commodity_state") //商品状态
    private String commodityState;

    @TableField("commodity_name") //商品名称
    private String commodityName;

    @TableField("commodity_stock") //商品库存
    private Integer commodityStock;

    @TableField("commodity_price") //商品价格
    private Integer commodityPrice;

    @TableField("commodity_discount") //商品折扣
    private Integer commodityDiscount;

    @TableField("commodity_describe") //商品描述
    private Integer commodityDescribe;

    @TableField("commodity_delete") //商品删除状态（0-正常，1-删除）
    private Integer commodityDelete;

    @TableField("commodity_create_time") //商品创建时间
    private LocalDateTime commodityCreateTime;

    @TableField("commodity_update_time") //商品最近修改时间
    private LocalDateTime commodityUpdateTime;
}
