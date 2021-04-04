package com.ash.server.service.impl;

import com.ash.server.config.security.component.JwtTokenUtil;
import com.ash.server.mapper.UserMapper;
import com.ash.server.pojo.*;
import com.ash.server.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService,UserDetailsService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @param code
     * @param request
     * @return com.ash.server.pojo.RespBean
     * @author ash
     */
    @Override
    public RespBean userLogin(AdminLoginParam userLoginParam, HttpServletRequest request){
        String captcha = (String) request.getSession().getAttribute("captcha");
        if (StringUtils.isEmpty(userLoginParam.getCode())||!captcha.equalsIgnoreCase(userLoginParam.getCode())){
            return RespBean.error("验证码输入错误，请重新输入!");
        }
        //登录
        UserDetails userDetails=loadUserByUsername(userLoginParam.getUsername());
        if (null==userDetails||!passwordEncoder.matches(userLoginParam.getPassword(),userDetails.getPassword())){
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
        Map<String,String> tokenMap=new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return RespBean.success("登录成功",tokenMap);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.selectOne(
                new QueryWrapper<User>()
                        .eq("user_username",username)
                        .eq("user_enabled",true));
    }

    @Override
    public RespBean addUser(User user) {
        String password=passwordEncoder.encode(user.getUserPassword());
        user.setUserPassword(password);
        if (1==userMapper.insert(user)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败!");
    }

    @Override
    public RespBean updateUser(User user) {
        String password=passwordEncoder.encode(user.getUserPassword());
        user.setUserPassword(password);
        if (1==userMapper.updateById(user)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败!");
    }

    @Override
    public UserDetails loadUserByUsername(String userUsername) throws UsernameNotFoundException {
        return userMapper.selectOne(new QueryWrapper<User>()
                .eq("user_username",userUsername)
                .eq("user_enabled",true));
    }
}
