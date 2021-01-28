package com.ash.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 公共返回对象
 * @Author ash
 * @Date 2021/1/26 22:17
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object obj;

    /** 
     * @Description: 成功返回结果 
     * @Param: [message] 
     * @Return: com.ash.server.pojo.RespBean 
     * @Author ash
     * @Date: 22:20 2021/1/26
     */ 
    public static RespBean success(String message){
        return new RespBean(200,message,null);
    }

    /** 
     * @Description: 成功返回结果
     * @Param: [message, obj] 
     * @Return: com.ash.server.pojo.RespBean 
     * @Author ash
     * @Date: 22:20 2021/1/26
     */ 
    public static RespBean success(String message,Object obj){
        return new RespBean(200,message,obj);
    }

    /**
     * @Description: 失败返回结果
     * @Param: [message]
     * @Return: com.ash.server.pojo.RespBean
     * @Author ash
     * @Date: 22:21 2021/1/26
     */
    public static RespBean error(String message){
        return new RespBean(500,message,null);
    }

    /**
     * @Description: 失败返回结果
     * @Param: [message, obj]
     * @Return: com.ash.server.pojo.RespBean
     * @Author ash
     * @Date: 22:21 2021/1/26
     */
    public static RespBean error(String message,Object obj){
        return new RespBean(500,message,obj);
    }
}
