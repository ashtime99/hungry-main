package com.xyc.hungry.web.client;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: hungry
 * @description: hello world
 * @author: ash
 * @create: 2021/01/09 15:49
 */
@RestController
public class HelloController {

        /*
         * @Description:
         * @Author: ash
         * @Date: 2021/1/9 15:51
         * @Param: []
         * @Return: java.lang.String
         **/
        @ApiOperation("hello word")
        @GetMapping("/hello")
        public String hello(){
            return "hello world";
        }
}

