package com.xyc.hungry.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xyc.hungry.dao.AdminMapper;
import com.xyc.hungry.model.Admin;
import com.xyc.hungry.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @program: hungry-main
 * @description:
 * @author: ash
 * @create: 2021/01/12 16:39
 */
@Service
public class AdminServiceImpl implements AdminService, UserDetailsService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Admin> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("admin_username",username);
        Admin admin=adminMapper.selectOne(queryWrapper);
        if (admin==null){
            throw new UsernameNotFoundException("账户不存在");
        }
        admin.setRoles(adminMapper.getAdminRolesByUid(admin.getAdminId()));
        return admin;
    }

    @Override
    public Admin findAdminByUserNameAndPassword(String username, String initCode) {
        QueryWrapper<Admin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("admin_username",username).eq("admin_password",initCode).eq("admin_delete",0);
        Admin admin = adminMapper.selectOne(queryWrapper);
        return admin;
    }
}
