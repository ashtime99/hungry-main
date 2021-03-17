package com.ash.server.mapper;

import com.ash.server.pojo.Commodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
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

    /** 
     * @Description: 获取所有菜品（分页） 
     * @Param: [page, commodity, beginDataScope] 
     * @Return: com.baomidou.mybatisplus.core.metadata.IPage<com.ash.server.pojo.Commodity> 
     * @Author ash
     * @Date: 15:16 2021/3/16
     */ 
    IPage<Commodity> getCommodityByPage(Page<Commodity> page,
                                        @Param("keywords") String keywords);
}
