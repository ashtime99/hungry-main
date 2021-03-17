package com.ash.server.mapper;

import com.ash.server.pojo.Commodity;
import com.ash.server.pojo.CommodityCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ash
 * @since 2021-03-15
 */
public interface CommodityCategoryMapper extends BaseMapper<CommodityCategory> {
    /** 
     * @Description: 获取所有商品
     * @Param: [keywords] 
     * @Return: java.util.List<com.ash.server.pojo.Commodity> 
     * @Author ash
     * @Date: 14:50 2021/3/16
     */ 
    List<Commodity> getAllCommodityInfo(@Param("keywords") String keywords);
}
