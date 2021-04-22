package com.ash.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/4/20 14:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "OrderPay对象",description = "")
public class OrderPay {
    @ApiModelProperty(value = "用户名",required = true)
    private Long oid;
    @ApiModelProperty(value = "密码",required = true)
    private BigDecimal amount;
}
