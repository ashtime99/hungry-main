package com.ash.server.util;

import com.ash.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Description TODO
 * @Author ash
 * @Date 2021/3/11 13:31
 * @Version 1.0
 **/
public class AdminUtils {

    /** 
     * @Description: 获取当前用户
     * @Param: [] 
     * @Return: com.ash.server.pojo.Admin 
     * @Author ash
     * @Date: 13:40 2021/3/11
     */ 
    public static Admin getCurrentAdmin(){
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
