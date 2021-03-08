package com.ash.server.service;

import com.ash.server.pojo.User;
import com.ash.server.pojo.UserLoginParam;
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
    User userLogin(UserLoginParam userLoginParam, HttpServletRequest request);
}
