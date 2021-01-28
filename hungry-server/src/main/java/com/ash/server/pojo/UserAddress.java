package com.ash.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("h_user_address")
@ApiModel(value="UserAddress对象", description="")
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "地址id")
    private Integer addressId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "详细地址")
    private String addressDescribe;

    @ApiModelProperty(value = "地址删除状态（默认0，0-正常，1-删除）")
    private Boolean addressDelete;

    @ApiModelProperty(value = "地址创建时间")
    private LocalDateTime addressCreateTime;

    @ApiModelProperty(value = "地址最近修改时间")
    private LocalDateTime addressUpdateTime;


}
