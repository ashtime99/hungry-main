package com.ash.server.service.impl;

import com.ash.server.pojo.Category;
import com.ash.server.mapper.CategoryMapper;
import com.ash.server.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ash
 * @since 2021-03-15
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
