package com.xyc.hungry.model;

import com.baomidou.mybatisplus.annotation.*;
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

    @TableField(value ="user_state",fill = FieldFill.INSERT) //用户状态
    private Integer userState;

    @TableField(value = "user_delete",fill = FieldFill.INSERT) //用户删除状态
    private Integer userDelete;

    @TableField(value = "user_login_time",fill = FieldFill.INSERT_UPDATE) //用户最近登录时间
    private LocalDateTime userLoginTime;

    @TableField(value = "user_create_time",fill = FieldFill.INSERT) //用户创建时间
    private LocalDateTime userCreateTime;

    @TableField(value = "user_update_time",fill = FieldFill.INSERT_UPDATE) //用户最近修改时间
    private LocalDateTime userUpdateTime;
}
