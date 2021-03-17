package com.ash.server.service;

import com.ash.server.pojo.UserAddress;
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
public interface IUserAddressService extends IService<UserAddress> {

    List<UserAddress> getUserAddress(Integer userId);
}
