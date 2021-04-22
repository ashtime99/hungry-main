package com.ash.server.service;

import com.ash.server.pojo.AdminLoginParam;
import com.ash.server.pojo.RespBean;
import com.ash.server.pojo.User;
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
public interface IUserService extends IService<User> {

    /**
     * @Description: 用户登录
     * @Param: [userLoginParam, request]
     * @Return: com.ash.server.pojo.User
     * @Author ash
     * @Date: 15:34 2021/2/10
     */
    RespBean userLogin(AdminLoginParam userLoginParam, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return com.ash.server.pojo.User
     * @author ash
     */
    User getUserByUsername(String username);

    /**
     * 添加用户
     *
     * @param user
     * @return com.ash.server.pojo.RespBean
     * @author ash
     */
    RespBean addUser(User user);

    /**
     * 更新
     *
     * @param user
     * @return com.ash.server.pojo.RespBean
     * @author ash
     */
    RespBean updateUser(User user);
}
