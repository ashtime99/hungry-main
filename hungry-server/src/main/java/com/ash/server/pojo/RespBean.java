package com.ash.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 公共返回对象
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/3/30 12:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="RespBean对象", description="公共返回对象")
public class RespBean {

    @ApiModelProperty("状态码")
    private long code;
    @ApiModelProperty("返回内容")
    private String message;
    @ApiModelProperty("返回数据")
    private Object data;

    /**
     * 成功返回结果
     *
     * @param message 返回内容
     * @return com.ash.server.pojo.RespBean
     * @author ash
     */
    public static RespBean success(String message){
        return new RespBean(200,message,null);
    }

    /**
     * 成功返回结果
     *
     * @param message 返回内容
     * @param data 返回数据
     * @return com.ash.server.pojo.RespBean
     * @author ash
     */
    public static RespBean success(String message,Object data){
        return new RespBean(200,message,data);
    }

    /**
     * 失败返回结果
     *
     * @param message 返回内容
     * @return com.ash.server.pojo.RespBean
     * @author ash
     */
    public static RespBean error(String message){
        return new RespBean(500,message,null);
    }

    /**
     * 失败返回结果
     *
     * @param message 返回内容
     * @param data 返回数据
     * @return com.ash.server.pojo.RespBean
     * @author ash
     */
    public static RespBean error(String message,Object data){
        return new RespBean(500,message,data);
    }
}
