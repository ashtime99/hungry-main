package com.xyc.hungry.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: hungry
 * @description: User 用户
 * @author: ash
 * @create: 2020/12/15 20:13
 */

@Data
@TableName("user")
public class User {

    @TableId("user_id") //用户id
    private Integer userId;

    @TableField("image_id") //图片id
    private Integer imageId;

    @TableField("user_username") //用户账户
    private String userUsername;

    @TableField("user_password") //用户密码
    private String userPassword;

    @TableField("user_nickname") //用户昵称
    private String userNickname;

    @TableField("user_age") //用户年龄
    private Integer userAge;

    @TableField("user_phone") //用户号码
    private String userPhone;

    @TableField("user_state") //用户状态
    private String userState;

    @TableField("user_delete") //用户删除状态
    private String userDelete;

    @TableField("user_login_time") //管理员最近登录时间
    private LocalDateTime userLoginTime;

    @TableField("user_create_time") //用户创建时间
    private LocalDateTime userCreateTime;

    @TableField("user_update_time") //用户最近修改时间
    private LocalDateTime userUpdateTime;
}
