package com.xyc.hungry.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xyc.hungry.model.User;

import java.util.List;

/**
 * @program: hungry
 * @description: UserService 用户业务
 * @author: ash
 * @create: 2021/01/09 22:46
 */
public interface UserService {

    /*
     * @Description: 用户登录
     * @Author: ash
     * @Date: 2021/1/9 22:50
     * @Param: [userUsername, userPassword]
     * @Return: com.xyc.hungry.model.User
     **/
    User userLogin(String userUsername, String userPassword);

    /*
     * @Description: 用户注册
     * @Author: ash
     * @Date: 2021/1/9 22:51
     * @Param: [user]
     * @Return: java.lang.Integer
     **/
    Integer userRegister(User user);

    /*
     * @Description: 根据用户id显示一条用户记录
     * @Author: ash
     * @Date: 2021/1/9 22:55
     * @Param: [userId]
     * @Return: com.xyc.hungry.model.User
     **/
    User selectUserById(Integer userId);

    /*
     * @Description: 分页显示所有用户记录
     * @Author: ash
     * @Date: 2021/1/9 23:57
     * @Param: [page, state]
     * @Return: java.util.List<com.xyc.hungry.model.User>
     **/
    List<User> selectUserList(IPage<User> page, Integer state);

    /*
     * @Description: 根据用户id更新一条用户记录
     * @Author: ash
     * @Date: 2021/1/9 23:06
     * @Param: [userId, user]
     * @Return: java.lang.Integer
     **/
    Integer updateUserById(User user);

    /*
     * @Description: 批量删除
     * @Author: ash
     * @Date: 2021/1/9 23:15
     * @Param: [userIds]
     * @Return: java.util.List<com.xyc.hungry.model.User>
     **/
    List<User> updateUserListByIds(List<Integer>userIds);

    /*
     * @Description: 根据用户id修改用户删除状态（假删除）
     * @Author: ash
     * @Date: 2021/1/9 23:00
     * @Param: [user]
     * @Return: java.lang.Integer
     **/
    Integer deleteUserById(Integer userId);

}
