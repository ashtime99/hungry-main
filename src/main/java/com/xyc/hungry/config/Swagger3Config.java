package com.xyc.hungry.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @program: hungry
 * @description: swagger3
 * @author: ashtime99
 * @create: 2021/01/04 10:24
 */
@Configuration
public class Swagger3Config {
    @Bean
    public Docket createRestApi() {
        Docket build = new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
        return build;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Hungry")
                .description("基于JavaEE的校园外卖订餐管理系统设计与实现")
                .contact(new Contact("ashtime99", "https://github.ashtime99.io","2356530007@qq.com"))
                .version("1.0")
                .build();
    }
}
