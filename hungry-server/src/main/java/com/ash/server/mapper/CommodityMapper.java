package com.ash.server.mapper;

import com.ash.server.pojo.Commodity;
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
public interface CommodityMapper extends BaseMapper<Commodity> {

    /**
     * @Description: 获取所有商品
     * @Param: [keywords]
     * @Return: java.util.List<com.ash.server.pojo.Commodity>
     * @Author ash
     * @Date: 15:26 2021/3/15
     */
    List<Commodity> getAllCommodity(@Param("keywords") String keywords);
}
