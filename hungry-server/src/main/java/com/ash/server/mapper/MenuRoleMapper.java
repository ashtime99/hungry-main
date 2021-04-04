package com.ash.server.mapper;

import com.ash.server.pojo.MenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */

@Repository
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    Integer insertRecord(Integer roleId, Integer[] menuIds);
}
