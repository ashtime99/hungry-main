package com.ash.server.service.impl;

import com.ash.server.mapper.UserMapper;
import com.ash.server.pojo.User;
import com.ash.server.pojo.UserLoginParam;
import com.ash.server.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @Description: 用户登录
     * @Param: [userLoginParam, request]
     * @Return: com.ash.server.pojo.User
     * @Author ash
     * @Date: 15:33 2021/2/10
     */
    @Override
    public User userLogin(UserLoginParam userLoginParam, HttpServletRequest request) {
        return null;
    }
}
