package com.ash.server.service;

import com.ash.server.pojo.MenuRole;
import com.ash.server.pojo.RespBean;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
public interface IMenuRoleService extends IService<MenuRole> {

    RespBean updateMenuRole(Integer roleId, Integer[] menuIds);
}
