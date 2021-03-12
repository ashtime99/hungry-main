package com.ash.server.service.impl;

import com.ash.server.AdminUtils;
import com.ash.server.config.security.component.JwtTokenUtil;
import com.ash.server.mapper.AdminMapper;
import com.ash.server.mapper.AdminRoleMapper;
import com.ash.server.mapper.RoleMapper;
import com.ash.server.pojo.Admin;
import com.ash.server.pojo.AdminRole;
import com.ash.server.pojo.RespBean;
import com.ash.server.pojo.Role;
import com.ash.server.service.IAdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * @Description: 登录之后返回token
     * @Param: [username, password, request]
     * @Return: com.ash.server.pojo.RespBean
     * @Author ash
     * @Date: 22:47 2021/1/26
     */
    @Override
    public RespBean login(String username, String password,String code,HttpServletRequest request) {
        String captcha = (String) request.getSession().getAttribute("captcha");
        if (StringUtils.isEmpty(code)||!captcha.equalsIgnoreCase(code)){
            return RespBean.error("验证码输入错误，请重新输入!");
        }
        //登录
        UserDetails userDetails=userDetailsService.loadUserByUsername(username);
        if (null==userDetails||!passwordEncoder.matches(password,userDetails.getPassword())){
            return RespBean.error("用户名或者密码不正确");
        }
        if (!userDetails.isEnabled()){
            return RespBean.error("账号被禁用,请联系数据管理员!");
        }
        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetails,
                null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //生成token
        String token=jwtTokenUtil.generateToken(userDetails);
        Map<String,String>tokenMap=new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return RespBean.success("登录成功",tokenMap);
    }

    
    /** 
     * @Description: 根据用户名获取用户
     * @Param: [username] 
     * @Return: com.ash.server.pojo.Admin 
     * @Author ash
     * @Date: 11:32 2021/1/27
     */ 
    @Override
    public Admin getAdminByUsername(String adminUsername) {
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("admin_username",adminUsername).eq("admin_enabled",true));
    }

    /** 
     * @Description: 根据用户id查询角色列表 
     * @Param: [adminId] 
     * @Return: java.util.List<com.ash.server.pojo.Role> 
     * @Author ash
     * @Date: 17:25 2021/2/5
     */ 
    @Override
    public List<Role> getRoles(Integer adminId) {
        return roleMapper.getRoles(adminId);
    }

    /** 
     * @Description: 获取所有操作员
     * @Param: [keywords] 
     * @Return: java.util.List<com.ash.server.pojo.Admin> 
     * @Author ash
     * @Date: 13:22 2021/3/11
     */ 
    @Override
    public List<Admin> getAllAdmins(String keywords) {
        return adminMapper.getAllAdmin(AdminUtils.getCurrentAdmin().getAdminId(),keywords);
    }

    /**
     * @Description: 更新操作员角色
     * @Param: [adminId, roleIds]
     * @Return: com.ash.server.pojo.RespBean
     * @Author ash
     * @Date: 17:50 2021/3/11
     */
    @Override
    @Transactional
    public RespBean updateAdminRole(Integer adminId, Integer[] roleIds) {
        adminRoleMapper.delete(new QueryWrapper<AdminRole>().eq("admin_id",adminId));
        Integer result=adminRoleMapper.addAdminRole(adminId,roleIds);
        if (roleIds.length==result){
            return RespBean.success("更新成功!");
        }else{
            return RespBean.error("更新失败！");
        }
    }
}
