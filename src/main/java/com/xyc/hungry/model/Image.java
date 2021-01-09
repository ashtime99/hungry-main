package com.xyc.hungry.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: hungry
 * @description: Image 图片
 * @author: ash
 * @create: 2020/12/17 21:57
 */
@Data
@TableName("image")
public class Image {

    @TableId("image_id")
    private Integer imageId; //图片id

    @TableField("image_url") //图片地址
    private String imageUrl;

    @TableField("image_delete") //图片删除状态
    private String imageDelete;

    @TableField("image_create_time") //图片创建时间
    private LocalDateTime imageCreateTime;

    @TableField("image_update_time") //图片最近修改时间
    private LocalDateTime imageUpdateTime;
}
