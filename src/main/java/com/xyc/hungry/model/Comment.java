package com.xyc.hungry.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: hungry
 * @description: Comment 评价
 * @author: ash
 * @create: 2021/01/09 16:38
 */
@Data
@TableName("comment")
public class Comment {

    @TableId("comment_id") //评价id
    private Integer commentId; //评价id

    @TableField("user_id") //用户id
    private Integer userId;

    @TableField("commodity_id") //商品id
    private Integer commodityId;

    @TableField("comment_score") //评价分
    private Integer commentScore;

    @TableField("comment_state") //评价状态
    private Byte   commentState;

    @TableField("comment_content") //评价内容
    private String commentContent;

    @TableField("comment_delete") //评价删除状态
    private Byte commentDelete;

    @TableField("comment_create_time") //评价创建时间
    private LocalDateTime commentCreateTime;

    @TableField("comment_update_time") //评价最近修改时间
    private LocalDateTime commentUpdateTime;
}
