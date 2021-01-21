package com.xyc.hungry.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xyc.hungry.dao.RoleMapper;
import com.xyc.hungry.model.Role;
import com.xyc.hungry.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: hungry-main
 * @description:
 * @author: ash
 * @create: 2021/01/13 20:21
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;


    @Override
    public List<Role> selectAllRole() {
        return roleMapper.selectList(null);
    }

}
