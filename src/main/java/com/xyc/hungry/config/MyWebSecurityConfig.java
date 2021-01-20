package com.xyc.hungry.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyc.hungry.service.AdminService;
import com.xyc.hungry.service.impl.AdminServiceImpl;
import com.xyc.hungry.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: hungry-main
 * @description: MyWebSecurityConfig
 * @author: ash
 * @create: 2021/01/11 20:28
 */
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    AdminServiceImpl adminService;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(adminService);
//        //密码需要设置编码器
//        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
//        //使用内存用户信息
//        auth.inMemoryAuthentication().passwordEncoder(encoder)
//                .withUser("xyc").password(encoder.encode("123")).roles("admin")
//                .and()
//                .withUser("user").password(encoder.encode("123")).roles("user");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/layuiadmin/**").permitAll()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().disable()
                .and()
                .formLogin()
                .loginPage("/admin/login").permitAll()
                .usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl("/admin/index")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        Object principal= authentication.getPrincipal();
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out=httpServletResponse.getWriter();
                        httpServletResponse.setStatus(200);
                        Map<String,Object> map=new HashMap<>();
                        map.put("principal",principal);
                        Msg msg=new Msg();
                        msg.setCode(200);
                        msg.setData(map);
                        msg.setMsg("登录成功");
                        ObjectMapper om=new ObjectMapper();
                        out.write(om.writeValueAsString(msg));
                        out.flush();
                        out.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out=httpServletResponse.getWriter();
                        httpServletResponse.setStatus(401);
                        Msg msg=new Msg();
                        msg.setCode(401);
                        if (e instanceof LockedException){
                            msg.setMsg("账户被锁定，登录失败！");
                        }else if(e instanceof BadCredentialsException){
                            msg.setMsg("账户或密码输入失败，登录失败！");
                        }else if(e instanceof DisabledException){
                            msg.setMsg("账户被禁用，登录失败！");
                        }else if(e instanceof AccountExpiredException){
                            msg.setMsg("账户已过期，登录失败！");
                        }else if(e instanceof CredentialsExpiredException){
                            msg.setMsg("密码已过期，登录失败！");
                        }else{
                            msg.setMsg("登录失败！");
                        }
                        ObjectMapper om=new ObjectMapper();
                        out.write(om.writeValueAsString(msg));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .csrf().disable();

    }
}
