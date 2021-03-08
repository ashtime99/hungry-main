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

        @GetMapping("/order/beReceived/hello")
        public String hello2(){
                return "操作员：/order/beReceived/hello";
        }

        @GetMapping("/order/beDelivered/hello")
        public String hello3(){
                return "配送员：/order/beDelivered/hello";
        }

}

