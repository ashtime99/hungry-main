package com.xyc.hungry.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: hungry
 * @description: Shop 店铺
 * @author: ash
 * @create: 2021/01/09 20:44
 */
@Data
@TableName("image")
public class Shop {

    @TableId("shop_id") //商铺id
    private Integer shopId;

    @TableField("image_id") //图片id
    private Integer imageId;

    @TableField("shop_name") //商铺名称
    private String shopName;

    @TableField("shop_content") //商铺简介
    private String shopContent;

    @TableField("shop_delete") //商铺删除状态（默认0，0-正常，1-删除）
    private Byte shopDelete;

    @TableField("shop_create_time") //商铺创建时间
    private LocalDateTime shopCreateTime;

    @TableField("shop_update_time") //商铺最近修改时间
    private LocalDateTime shopUpdateTime;
}
