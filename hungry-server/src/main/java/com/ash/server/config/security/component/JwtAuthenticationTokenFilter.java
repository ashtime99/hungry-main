package com.ash.server.config.security.component;

import com.ash.server.service.IAdminService;
import com.ash.server.service.IUserService;
import com.ash.server.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description JWT登录授权过滤器
 * @Author ash
 * @Date 2021/1/27 16:10
 * @Version 1.0
 **/

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private IAdminService adminService;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authHeader=httpServletRequest.getHeader(tokenHeader);
        //存在token
        if (null!=authHeader && authHeader.startsWith(tokenHead)){
            String authToken=authHeader.substring(tokenHead.length());
            String username=jwtTokenUtil.getUsernameFromToken(authToken);
            //token存在用户名但未登录
            if (null!=username&&null== SecurityContextHolder.getContext().getAuthentication()){
                //登录
                UserDetails userDetails=userDetailsService.loadUserByUsername(username);
                if (null==userDetails){
                    userDetails=userService.loadUserByUsername(username);
                }
                //验证token是否有效，重新设置用户对象
                if (jwtTokenUtil.validateToken(authToken,userDetails)){
                    UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
