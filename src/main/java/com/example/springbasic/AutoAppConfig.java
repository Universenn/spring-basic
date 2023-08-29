package com.example.springbasic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.example.springbasic",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // @Configuration 어노테이션이 들어간 타입은 필터로 빼준다.
        // basePackageClasses = AutoAppConfig.class 지정하지 않으면 본인 패키지가 시작 위치가 된다.

)
public class AutoAppConfig {
}
