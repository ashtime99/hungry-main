package com.ash.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description 用户登录实体类
 * @Author ash
 * @Date 2021/2/10 15:30
 * @Version 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserLoginParam对象",description = "")
public class UserLoginParam {
    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @ApiModelProperty(value = "密码",required = true)
    private String password;
    @ApiModelProperty(value = "验证码",required = true)
    private String code;
}
