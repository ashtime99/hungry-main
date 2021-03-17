package com.ash.server.service.impl;

import com.ash.server.mapper.ShoppingcartMapper;
import com.ash.server.pojo.Shoppingcart;
import com.ash.server.service.IShoppingcartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
@Service
public class ShoppingcartServiceImpl extends ServiceImpl<ShoppingcartMapper, Shoppingcart> implements IShoppingcartService {

    @Override
    public List<Shoppingcart> getShoppingcartByUser(Integer userId) {
        return baseMapper.getShoppingcartByUser(userId);
    }
}
