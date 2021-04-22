package com.ash.server.service.impl;

import com.ash.server.mapper.ShoppingcartMapper;
import com.ash.server.pojo.RespBean;
import com.ash.server.pojo.Shoppingcart;
import com.ash.server.service.IShoppingcartService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
@Service
public class ShoppingcartServiceImpl extends ServiceImpl<ShoppingcartMapper, Shoppingcart> implements IShoppingcartService {

    @Override
    public List<Shoppingcart> getShoppingcartByUser(Long userId) {
        return baseMapper.getShoppingcartByUser(userId);
    }

    @Override
    public RespBean addShoppingcart(Shoppingcart shoppingcart) {
        //如果存在
        Integer count = baseMapper.selectCount(new QueryWrapper<Shoppingcart>().eq("commodity_id", shoppingcart.getCommodityId()));
        if (count > 0) {
            shoppingcart = baseMapper.selectOne(new QueryWrapper<Shoppingcart>().eq("commodity_id", shoppingcart.getCommodityId()));
            shoppingcart.setShoppingcartNum(shoppingcart.getShoppingcartNum() + 1);
            if (1==baseMapper.updateById(shoppingcart)) {
                return RespBean.success("添加购物车成功！");
            } else {
                return RespBean.error("添加购物车失败！");
            }
        } else {
            if (1==baseMapper.insert(shoppingcart)) {
                return RespBean.success("添加购物车成功！");
            } else {
                return RespBean.error("添加购物车失败！");
            }
        }

    }
}
