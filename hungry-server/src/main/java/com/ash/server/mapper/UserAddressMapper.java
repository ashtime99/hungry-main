package com.ash.server.mapper;

import com.ash.server.pojo.UserAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */

@Repository
public interface UserAddressMapper extends BaseMapper<UserAddress> {

    List<UserAddress> getUserAddress(@Param("userId") Integer userId);
}
