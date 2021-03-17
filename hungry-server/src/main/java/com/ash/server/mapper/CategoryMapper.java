package com.ash.server.mapper;

import com.ash.server.pojo.Category;
import com.ash.server.pojo.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ash
 * @since 2021-03-15
 */
public interface CategoryMapper extends BaseMapper<Category> {



    /**
     * @Description: 根据商品id查询类别列表
     * @Param: [commodityId]
     * @Return: java.util.List<com.ash.server.pojo.Category>
     * @Author ash
     * @Date: 11:26 2021/3/17
     */
    List<Category> getCategory(Integer commodityId);
}
