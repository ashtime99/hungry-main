package com.ash.server.mapper;

import com.ash.server.pojo.MenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    Integer insertRecord(Integer roleId, Integer[] menuIds);
}
