package com.ash.server.service.impl;

import com.ash.server.pojo.Menu;
import com.ash.server.service.IMenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MenuServiceImplTest {

    @Autowired
    IMenuService menuService;

    @Test
    void getMenusByAdminId() {
    }

    @Test
    void getMenusWithRole() {
        List<Menu> menus=menuService.getMenusWithRole();
        for (Menu menu:menus){
            System.out.println(menu);
        }
    }
}