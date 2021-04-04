package com.ash.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Description: 商品规格
 * @Author ash
 * @Date 2021/3/19 17:15
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("h_spec")
@ApiModel(value="spec对象", description="")
public class Spec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "spec_id", type = IdType.AUTO)
    private Integer specId;

    private String specName;


}
