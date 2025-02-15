package com.example.movie.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {

        List<Predicate<RequestHandler>> predicateList = new ArrayList<>();
        predicateList.add(RequestHandlerSelectors.basePackage("com.example.movie.controller"));
        predicateList.add(RequestHandlerSelectors.basePackage("com.example.movie.admin"));
        predicateList.add(RequestHandlerSelectors.basePackage("com.example.movie.map"));
        predicateList.add(RequestHandlerSelectors.basePackage("com.example.movie.page"));

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerInfo())
                .groupName("Test")
                .select()
                .apis(Predicates.or(predicateList))
                .paths(PathSelectors.ant("/**"))
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder().title("Movie Theater API Documentation")
                .description("영화예매사이트 API 입니다.")
                .license("")
                .version("1.0")
                .build();
    }
}