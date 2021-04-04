package com.ash.server.controller;


import com.ash.server.pojo.Category;
import com.ash.server.service.ICategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 分类前端控制器
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/3/29 12:07
 */
@RestController
@RequestMapping("/category")
@Api(tags = "商品分类API")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    @ApiOperation("获取所有类别")
    public List<Category> getCategorie(){
        return categoryService.list();
    }
}
