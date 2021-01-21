package com.xyc.hungry.service;

import com.xyc.hungry.model.Admin;
import com.xyc.hungry.model.User;

/**
 * @program: hungry-main
 * @description:
 * @author: ash
 * @create: 2021/01/12 16:39
 */
public interface AdminService {

    /*
     * @Description: 管理员登录
     * @Author: ash
     * @Date: 2021/1/12 22:01
     * @Param: [username, initCode]
     * @Return: com.xyc.hungry.model.Admin
     **/
    Admin findAdminByUserNameAndPassword(String username, String initCode);

    /*
     * @Description: 管理员注册
     * @Author: ash
     * @Date: 2021/1/13 14:17
     * @Param: [admin]
     * @Return: java.lang.Integer
     **/
    Integer adminRegister(Admin admin);

    /*
     * @Description: 根据管理员id更新一条管理员记录
     * @Author: ash
     * @Date: 2021/1/13 14:31
     * @Param: [admin]
     * @Return: java.lang.Integer
     **/
    Integer updateAdminById(Admin admin);


}
