package com.xyc.hungry.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xyc.hungry.dao.UserMapper;
import com.xyc.hungry.model.User;
import com.xyc.hungry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: hungry
 * @description:
 * @author: ash
 * @create: 2021/01/09 22:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User userLogin(String userUsername, String userPassword) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("user_username",userUsername).like("user_password",userPassword);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public Integer userRegister(User user) {
        Integer row=userMapper.insert(user);
        return row;
    }

    @Override
    public User selectUserById(Integer userId) {
        return userMapper.selectUserById(userId,0);
    }

    @Override
    public List<User> selectUserList(IPage<User> page, Integer state) {
        //userMapper.selectUserList(page,state);
        return userMapper.selectUserList(page,state);
    }


    @Override
    public Integer updateUserById(Integer userId, User user) {
        return null;
    }

    @Override
    public List<User> updateUserListByIds(List<Integer> userIds) {
        return null;
    }

    @Override
    public Integer deleteUserById(Integer userId) {
        return null;
    }
}
