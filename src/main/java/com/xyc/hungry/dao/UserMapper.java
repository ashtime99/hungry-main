package com.xyc.hungry.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyc.hungry.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: hungry
 * @description: UserMapper
 * @author: ash
 * @create: 2020/12/16 21:24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
