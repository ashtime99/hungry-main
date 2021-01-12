package com.xyc.hungry.config;

import com.xyc.hungry.service.AdminService;
import com.xyc.hungry.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @program: hungry-main
 * @description: MyWebSecurityConfig
 * @author: ash
 * @create: 2021/01/11 20:28
 */
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

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
                .formLogin()
                .loginPage("/page/adminLogin").permitAll()
                .usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl("/page/adminIndex")
                .and()
                .csrf().disable();
    }
}
