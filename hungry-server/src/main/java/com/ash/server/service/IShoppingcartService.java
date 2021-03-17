package com.ash.server.service;

import com.ash.server.pojo.Shoppingcart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
public interface IShoppingcartService extends IService<Shoppingcart> {

    List<Shoppingcart> getShoppingcartByUser(Integer userId);
}
