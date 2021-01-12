package com.xyc.hungry.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyc.hungry.model.Commodity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: hungry
 * @description:
 * @author: ash
 * @create: 2021/01/10 20:06
 */
@Mapper
public interface CommodityMapper extends BaseMapper<Commodity> {
}
