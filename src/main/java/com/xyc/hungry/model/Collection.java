package com.xyc.hungry.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: hungry
 * @description: Collection 收藏
 * @author: ash
 * @create: 2021/01/09 16:34
 */
@Data
@TableName("collection")
public class Collection {

    @TableId("collection_id") //评价id
    private Integer collectionId;

    @TableField("user_id") //用户id
    private Integer userId;

    @TableField("commodity_id") //商品id
    private Integer commodityId;

    @TableField("collection_delete") //收藏删除状态
    private Byte collectionDelete;

    @TableField("collection_create_time") //收藏创建时间
    private LocalDateTime collectionCreateTime;

    @TableField("collection_update_time") //收藏最近修改时间
    private LocalDateTime collectionUpdateTime;
}
