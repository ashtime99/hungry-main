package com.ash.server.config.security;

import com.ash.server.config.security.component.*;
import com.ash.server.pojo.Admin;
import com.ash.server.pojo.User;
import com.ash.server.service.IAdminService;
import com.ash.server.service.IUserService;
import org.checkerframework.checker.units.qual.min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * <p>
 * Security配置类
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/4/1 17:18
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private IAdminService adminService;
    @Autowired
    private IUserService userService;
    @Autowired
    private RestAuthorizationEntryPoint restAuthorizationEntryPoint;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private CustomFilter customFilter;
    @Autowired
    private CustomUrlDecisionManager customUrlDecisionManager;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

//    @Override
//    @Bean
//    protected AuthenticationManager authenticationManager() throws Exception {
//        DaoAuthenticationProvider dao1 = new DaoAuthenticationProvider();
//        dao1.setUserDetailsService(us1());
//
//        DaoAuthenticationProvider dao2 = new DaoAuthenticationProvider();
//        dao2.setUserDetailsService(us2());
//
//        ProviderManager manager = new ProviderManager(dao1, dao2);
//        return manager;
//    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        //auth.userDetailsService(userService);
        //auth.parentAuthenticationManager(authenticationManager());
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers(
                "/login", "/logout", "/css/**", "/js/**", "/index.html", "favicon.ico",
                "/doc.html", "/swagger-resources/**", "/v2/api-docs/**", "/webjars/**",
                "/captcha","/images/**","/user/login","/order/pay/**"
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //使用JWT不需要csrf
        http.csrf()
                .disable()
                //基于token不需要session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //所有请求都要认证
                .anyRequest()
                .authenticated()
                //动态权限配置
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(customUrlDecisionManager);
                        o.setSecurityMetadataSource(customFilter);
                        return o;
                    }
                })
                .and()
                //禁用缓存
                .headers()
                .cacheControl();
        //添加JWT 登录授权过滤器
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthorizationEntryPoint);


    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        return username -> {
            Admin admin = adminService.getAdminByUsername(username);
            if (null != admin) {
                admin.setRoles(adminService.getRoles(admin.getAdminId()));
                return admin;
            }
            throw new UsernameNotFoundException("用户名或密码不正确");
        };
    }

//    @Bean
//    UserDetailsService us2() {
//        return adminUsername -> {
//            System.out.println("userUsername:"+adminUsername);
//            User user = userService.getUserByUsername(adminUsername);
//            if (null != user) {
//
//                return user;
//            }
//            throw new UsernameNotFoundException("账户或密码不正确");
//        };
//    }
//
//    @Bean
//    @Primary
//    UserDetailsService us1() {
//
//        return adminUsername -> {
//            System.out.println("adminUsername:"+adminUsername);
//            Admin admin = adminService.getAdminByUsername(adminUsername);
//            if (null != admin) {
//                admin.setRoles(adminService.getRoles(admin.getAdminId()));
//                return admin;
//            }else return null;
//            //throw new UsernameNotFoundException("账户或密码不正确");
//        };
//    }

}
