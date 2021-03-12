package com.ash.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description: User用户
 * @Author ash
 * @Date 2021/2/10 15:22
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("h_user")
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

//    @ApiModelProperty(value = "图片id")
//    private Integer imageId;

    @ApiModelProperty(value = "用户账户")
    private String userUsername;

    @ApiModelProperty(value = "用户密码")
    private String userPassword;

    @ApiModelProperty(value = "用户年龄")
    private Integer userAge;

    @ApiModelProperty(value = "用户号码")
    private String userPhone;

    @ApiModelProperty(value = "用户昵称")
    private String userNickname;

    @ApiModelProperty(value = "用户冻结状态")
    private Boolean userLocked;

    @ApiModelProperty(value = "用户删除状态")
    private Boolean userEnabled;

    @ApiModelProperty(value = "用户最近登录时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime userLoginTime;

    @ApiModelProperty(value = "用户创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime userCreateTime;

    @ApiModelProperty(value = "用户修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime userUpdateTime;


}
