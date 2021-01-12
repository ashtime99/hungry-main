package com.xyc.hungry.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program: hungry
 * @description: Admin 管理员
 * @author: ash
 * @create: 2020/12/15 20:37
 */

@Data
@TableName("admin")
public class Admin implements UserDetails {

    @TableId("admin_id") //管理员id
    private Integer adminId;

    @TableField("role_id") //管理员权限id
    private Integer roleId;

    @TableField("shop_id") //商铺id
    private Integer shopId;

    @TableField("admin_username") //管理员账户
    private String adminUsername;

    @TableField("admin_password") //管理员密码
    private String adminPassword;

    @TableField("admin_phone") //管理员号码
    private String adminPhone;

    @TableField("admin_create_time") //管理员创建时间
    private LocalDateTime adminCreateTime;

    @TableField("admin_login_time") //管理员最近登录时间
    private LocalDateTime adminLoginTime;

    @TableField("admin_update_time") //管理员最近修改时间
    private LocalDateTime adminUpdateTime;

    @TableField("enabled")
    private Boolean enabled;

    @TableField("locked")
    private Boolean locked;

    @TableField(exist = false)
    private List<Role>roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority>authorities=new ArrayList<>();
        for (Role role:roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return adminPassword;
    }

    @Override
    public String getUsername() {
        return adminUsername;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
