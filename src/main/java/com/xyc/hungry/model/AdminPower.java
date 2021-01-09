package com.xyc.hungry.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: hungry
 * @description: AdminPower 管理员权限
 * @author: ash
 * @create: 2020/12/17 22:04
 */

@Data
@TableName("admin_power")
public class AdminPower {

    @TableId("admin_power_id") //管理员权限id
    private Integer adminPowerId;

    @TableField("admin_power_name") //管理员权限名
    private String adminPowerName;
}
