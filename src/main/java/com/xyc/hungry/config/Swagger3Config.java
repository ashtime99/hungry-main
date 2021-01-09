package com.xyc.hungry.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
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
                .title("Swagger3接口文档")
                .description("ios demo")
                .contact(new Contact("ashtime99", "github.ashtime99.io","ashtime99@gmail.com"))
                .version("1.0")
                .build();
    }
}
