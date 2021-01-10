package com.xyc.hungry.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xyc.hungry.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: hungry
 * @description: UserMapper
 * @author: ash
 * @create: 2020/12/16 21:24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM user WHERE user_id=#{userId} AND user_delete=#{deleteState}")
    User selectUserById(@Param("userId") Integer userId, @Param("deleteState")Integer deleteState);

    @Select("SELECT * FROM user WHERE user_delete=#{deleteState}")
    List<User> selectUserList(IPage<User> page,@Param("deleteState")Integer deleteState);
}
