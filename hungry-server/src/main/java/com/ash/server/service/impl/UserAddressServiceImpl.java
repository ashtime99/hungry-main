package com.ash.server.service.impl;

import com.ash.server.mapper.UserAddressMapper;
import com.ash.server.pojo.UserAddress;
import com.ash.server.service.IUserAddressService;
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
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements IUserAddressService {

    @Override
    public List<UserAddress> getUserAddress(Integer userId) {
        return baseMapper.getUserAddress(userId);
    }
}
