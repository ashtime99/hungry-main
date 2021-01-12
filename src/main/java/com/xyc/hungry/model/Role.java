package com.xyc.hungry.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: hungry
 * @description: Role 管理员权限
 * @author: ash
 * @create: 2020/12/17 22:04
 */

@Data
@TableName("role")
public class Role {

    @TableId("role_id") //管理员权限id
    private Integer roleId;

    @TableField("role_name") //管理员权限名
    private String roleName;

    @TableField("role_name_zh") //管理员权限名
    private String roleNameZh;
}
