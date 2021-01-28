package com.ash.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试
 * @Author ash
 * @Date 2021/1/27 19:21
 * @Version 1.0
 */
@RestController
public class HelloController {

        @GetMapping("hello")
        public String hello(){
                return "hello";
        }

}

