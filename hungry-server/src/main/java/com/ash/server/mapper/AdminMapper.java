package com.ash.server.mapper;

import com.ash.server.pojo.Admin;
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
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 获取所有操作员
     *
     * @param adminId 管理员id
     * @param keywords 关键字
     * @return java.util.List<com.ash.server.pojo.Admin>
     * @author ash
     */
    List<Admin> getAllAdmin(@Param("adminId") Integer adminId, @Param("keywords") String keywords);

    //List<Admin> getAdmin(Integer adminId);
}
