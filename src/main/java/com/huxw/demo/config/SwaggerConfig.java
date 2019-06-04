package com.huxw.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: huxw
 * @Date: 2019-4-7 20:55
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.huxw.demo.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("计划管理")
                .description("计划管理中心 API 1.0 操作文档")
                //服务条款地址
                .termsOfServiceUrl("http://localhost:8080/plan/getPlans")
                .version("V1.0")
                .contact(new Contact("六重樱", "http://localhost:8080/plan/getPlans", "huxw1494@163.com"))
                .build();
    }
}
