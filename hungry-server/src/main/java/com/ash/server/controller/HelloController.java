package com.ash.server.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 测试
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/3/29 12:08
 */
@RestController
@Api(tags = "测试API")
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

