package com.xyc.hungry.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xyc.hungry.model.Admin;
import com.xyc.hungry.model.Role;
import com.xyc.hungry.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: hungry
 * @description: AdminMapper
 * @author: ash
 * @create: 2020/12/15 20:51
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    List<Role>getAdminRolesByUid(@Param("admin_id")Integer admin_id);
}
