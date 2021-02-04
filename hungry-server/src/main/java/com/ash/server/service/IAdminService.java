package com.ash.server.service;

import com.ash.server.pojo.Admin;
import com.ash.server.pojo.RespBean;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
public interface IAdminService extends IService<Admin> {

    /** 
     * @Description: 登录之后返回token
     * @Param: [username, password, request] 
     * @Return: com.ash.server.pojo.RespBean 
     * @Author ash
     * @Date: 23:00 2021/1/26
     */ 
    RespBean login(String username, String password,String code, HttpServletRequest request);

    /** 
     * @Description: 根据用户名获取用户
     * @Param: [username] 
     * @Return: com.ash.server.pojo.Admin 
     * @Author ash
     * @Date: 16:38 2021/1/27
     */ 
    Admin getAdminByUsername(String username);

}
