package com.xyc.hungry.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: hungry
 * @description: Admin 管理员
 * @author: ash
 * @create: 2020/12/15 20:37
 */

@Data
@TableName("admin")
public class Admin {

    @TableId("admin_id") //管理员id
    private Integer adminId;

    @TableField("admin_power_id") //管理员权限id
    private Integer adminPowerId;

    @TableField("shop_id") //商铺id
    private Integer shopId;

    @TableField("admin_username") //管理员账户
    private String adminUsername;

    @TableField("admin_password") //管理员密码
    private String adminPassword;

    @TableField("admin_phone") //管理员号码
    private String adminPhone;

    @TableField("admin_state") //管理员状态
    private Byte adminState;

    @TableField("admin_create_time") //管理员创建时间
    private LocalDateTime adminCreateTime;

    @TableField("admin_login_time") //管理员最近登录时间
    private LocalDateTime adminLoginTime;

    @TableField("admin_update_time") //管理员最近修改时间
    private LocalDateTime adminUpdateTime;
}
