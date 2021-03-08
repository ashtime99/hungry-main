package com.ash.server.mapper;

import com.ash.server.pojo.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
public interface RoleMapper extends BaseMapper<Role> {

    /** 
     * @Description: 根据用户id查询角色列表 
     * @Param: [adminId] 
     * @Return: java.util.List<com.ash.server.pojo.Role> 
     * @Author ash
     * @Date: 17:24 2021/2/5
     */ 
    List<Role> getRoles(Integer adminId);
}
