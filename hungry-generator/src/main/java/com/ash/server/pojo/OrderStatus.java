package com.ash.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("h_order_status")
@ApiModel(value="OrderStatus对象", description="")
public class OrderStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer orderStatusId;

    private String orderStatusName;


}
