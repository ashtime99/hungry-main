package com.xyc.hungry.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: hungry
 * @description: OrderDetailed 订单详情
 * @author: ash
 * @create: 2021/01/09 20:39
 */
@Data
@TableName("order_detailed")
public class OrderDetailed {

    @TableId("order_detailed_id") //订单子id
    private Integer orderDetailed_id;

    @TableField("order_id") //订单id
    private Integer orderId;

    @TableField("commodity_id") //商品id
    private Integer commodityId;

    @TableField("commodity_category_id") //订单规格id
    private Integer commodityCategoryId;

    @TableField("order_detailed_num") //订单数量
    private Integer orderDetailedNum;

    @TableField("order_detailed_price") //订单单价
    private Double orderDetailedPrice;
}
