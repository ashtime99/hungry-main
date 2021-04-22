package com.ash.server.service;

import com.ash.server.pojo.*;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author ash
 * @since 2021/3/29 11:58
 * @Version 1.0
 */
public interface IAdminService extends IService<Admin> {

    /** 
     * @Description: 登录之后返回token
     * @Param: [username, password, request] 
     * @Return: com.ash.server.pojo.RespBean 
     * @Author ash
     * @Date: 23:00 2021/1/26
     */ 
    RespBean login(AdminLoginParam adminLoginParam, HttpServletRequest request);

    /** 
     * @Description: 根据用户名获取用户
     * @Param: [username] 
     * @Return: com.ash.server.pojo.Admin 
     * @Author ash
     * @Date: 16:38 2021/1/27
     */ 
    Admin getAdminByUsername(String username);

    /** 
     * 根据用户id查询角色列表 
     * @Param: [adminId] 
     * @Return: java.util.List<com.ash.server.pojo.Role> 
     * @Author ash
     * @Date: 18:10 2021/3/23
     */ 
    List<Role>getRoles(Long adminId);

    /**
     * 获取所有管理员
     *
     * @param keywords 关键字
     * @return java.util.List<com.ash.server.pojo.Admin>
     * @author ash
     */
    List<Admin> getAllAdmins(String keywords);

    /**
     * 更新管理员权限
     *
     * @param adminId 管理员id
     * @param roleIds 权限ids
     * @return com.ash.server.pojo.RespBean
     * @author ash
     */
    RespBean updateAdminRole(Integer adminId, Integer[] roleIds);

    RespBean addAdmin(Admin admin);

    RespPageBean getAllAdminByPage(Integer currentPage, Integer size, Integer adminType, String keywords);
}
