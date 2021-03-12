package com.ash.server.service;

import com.ash.server.pojo.Admin;
import com.ash.server.pojo.RespBean;
import com.ash.server.pojo.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    /**
     * @Description: 根据用户id查询角色列表
     * @Author ash
     * @Date 2021/2/5 17:22
     * @Version 1.0
     */
    List<Role>getRoles(Integer adminId);

    /** 
     * @Description: 获取所有操作员
     * @Param: [keywords] 
     * @Return: java.util.List<com.ash.server.pojo.Admin> 
     * @Author ash
     * @Date: 13:22 2021/3/11
     */ 
    List<Admin> getAllAdmins(String keywords);

    /**
     * @Description: 更新操作员角色
     * @Param: [adminId, roleIds]
     * @Return: com.ash.server.pojo.RespBean
     * @Author ash
     * @Date: 17:40 2021/3/11
     */
    RespBean updateAdminRole(Integer adminId, Integer[] roleIds);
}
