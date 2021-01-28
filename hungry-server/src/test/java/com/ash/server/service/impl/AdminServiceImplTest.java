package com.ash.server.service.impl;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminServiceImplTest {

    @Autowired
    AdminServiceImpl adminService;

    @Test
    void getAdminByUsername() {
        System.out.println(adminService.getAdminByUsername("admin"));
    }
}