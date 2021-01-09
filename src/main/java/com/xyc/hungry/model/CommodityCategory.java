package com.xyc.hungry.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: hungry
 * @description: CommodityCategory 商品分类
 * @author: ash
 * @create: 2021/01/09 16:49
 */
@Data
@TableName("commodity_category")
public class CommodityCategory {

    @TableId("commodity_category_id") //商品规格id
    private Integer commodityCategoryId;

    @TableField("commodity_id") //商品id
    private Integer commodityId;

    @TableField("commodity_category_parent_id") //父商品规格id
    private Integer commodityCategoryParentId;

    @TableField("commodity_category_name") //商品规格名称
    private String commodityCategoryName;

    @TableField("commodity_category_delete") //商品规格删除状态
    private Byte commodityCategoryDelete;

    @TableField("commodity_category_create_time") //商品规格创建时间
    private LocalDateTime commodityCategoryCreateTime;

    @TableField("commodity_category_update_time") //商品规格最近修改时间
    private LocalDateTime commodityCategoryUpdateTime;
}
