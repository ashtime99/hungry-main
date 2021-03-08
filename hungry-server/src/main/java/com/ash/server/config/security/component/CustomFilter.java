package com.ash.server.config.security.component;

import com.ash.server.pojo.Menu;
import com.ash.server.pojo.Role;
import com.ash.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @Description 权限控制，判断请求url，分析请求所需的角色
 * @Author ash
 * @Date 2021/2/4 16:54
 * @Version 1.0
 **/

@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private IMenuService menuService;

    AntPathMatcher antPathMatcher=new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取请求的url
        String requestUrl=((FilterInvocation)o).getRequestUrl();
        List<Menu>menus=menuService.getMenusWithRole();
        for (Menu menu:menus){
            if (antPathMatcher.match(menu.getMenuUrl(),requestUrl)){
                String[] str=menu.getRoles().stream().map(Role::getRoleName).toArray(String[]::new);
                return SecurityConfig.createList(str);
            }
        }
        //没有匹配的url默认登录即可访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
