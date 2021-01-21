package com.xyc.hungry.service;

import com.xyc.hungry.model.Role;

import java.util.List;

/**
 * @program: hungry-main
 * @description:
 * @author: ash
 * @create: 2021/01/13 20:20
 */
public interface RoleService {
    /*
     * @Description: 显示所有权限
     * @Author: ash
     * @Date: 2021/1/13 20:21
     * @Param: []
     * @Return: java.util.List<com.xyc.hungry.model.Role>
     **/
    List<Role>selectAllRole();
}
