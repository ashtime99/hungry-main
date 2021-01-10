package com.xyc.hungry.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyc.hungry.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Test
    void userLogin() {
        System.out.println(userServiceImpl.userLogin("201902250101","123456"));
    }

    @Test
    void userRegister() {
        User user=new User();
        user.setUserUsername("201902250107");
        user.setUserPassword("123456");
        userServiceImpl.userRegister(user);
    }

    @Test
    void selectUserById() {
        System.out.println(userServiceImpl.selectUserById(9));
    }

    @Test
    void selectUserList() {
        IPage<User> userPage = new Page<>(1, 2);//参数一是当前页，参数二是每页个数
        List<User> userList=userServiceImpl.selectUserList(userPage,0);
        userList.forEach(System.out::println);

    }

    @Test
    void updateUserById() {
    }

    @Test
    void updateUserListByIds() {
    }

    @Test
    void deleteUserById() {
    }
}