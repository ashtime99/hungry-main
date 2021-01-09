package com.xyc.hungry.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: hungry
 * @description: UserAddress 用户地址
 * @author: ash
 * @create: 2020/12/17 22:06
 */

@Data
@TableName("user_address")
public class UserAddress {

    @TableId("address_id") //地址id
    private Integer addressId;

    @TableField("user_id") //用户id
    private Integer userId;

    @TableField("address_describe") //详细地址
    private String addressDescribe;

    @TableField("address_delete") //地址删除状态
    private String addressDelete;

    @TableField("address_create_time") //地址创建时间
    private LocalDateTime addressCreateTime;

    @TableField("address_update_time") //地址最近修改时间
    private LocalDateTime addressUpdateTime;
}
