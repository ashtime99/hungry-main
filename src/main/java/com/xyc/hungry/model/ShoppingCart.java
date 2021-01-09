package com.xyc.hungry.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: hungry
 * @description: ShoppingCart 购物车
 * @author: ash
 * @create: 2021/01/09 16:05
 */
@Data
@TableName("shoppingcart")
public class ShoppingCart {

    @TableId("shoppingcart_id") //购物车id
    private Integer shoppingCartId;

    @TableField("user_id") //用户id
    private Integer userId;

    @TableField("commodity_id") //商品id
    private Integer commodityId;

    @TableField("shoppingcart_num") //购物车数量
    private Integer shoppingCartNum;

    @TableField("shoppingcart_delete") //购物车删除状态
    private byte shoppingCart_delete;

    @TableField("shoppingcart_create_time") //购物车创建时间
    private LocalDateTime shoppingCartCreateTime;

    @TableField("shoppingcart_update_time") //购物车最近修改时间
    private LocalDateTime shoppingCartUpdateTime;
}
