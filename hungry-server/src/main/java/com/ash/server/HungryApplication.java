package com.ash.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: 启动类
 * @Author ash
 * @Date 2021/1/26 16:03
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.ash.server.mapper")
public class HungryApplication {
    public static void main(String[] args) {
        SpringApplication.run(HungryApplication.class,args);
    }
}
