package com.ash.server.service.impl;

import com.ash.server.mapper.MenuRoleMapper;
import com.ash.server.pojo.MenuRole;
import com.ash.server.pojo.RespBean;
import com.ash.server.service.IMenuRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

    @Override
    @Transactional // 开启事务
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        // 如果调用此接口，没传其它参数，证明是删除已有菜单
        baseMapper.delete(new QueryWrapper<MenuRole>().eq("role_id", rid));
        if (null == mids || 0 == mids.length) {
            return RespBean.success("更新成功！");
        }
        // 如果传参过来，新建批量更新方法，更新角色菜单
        Integer resule = baseMapper.insertRecord(rid, mids);
        if (resule == mids.length) {
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }
}
