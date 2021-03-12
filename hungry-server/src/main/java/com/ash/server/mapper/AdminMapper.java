package com.ash.server.mapper;

import com.ash.server.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ash
 * @since 2021-01-26
 */
public interface AdminMapper extends BaseMapper<Admin> {

    /** 
     * @Description: 获取所有操作员
     * @Param: [adminId, keywords] 
     * @Return: java.util.List<com.ash.server.pojo.Admin> 
     * @Author ash
     * @Date: 13:42 2021/3/11
     */ 
    List<Admin> getAllAdmin(@Param("adminId") Integer adminId, @Param("keywords") String keywords);
}
