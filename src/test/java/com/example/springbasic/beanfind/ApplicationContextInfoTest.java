package com.example.springbasic.beanfind;

import com.example.springbasic.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 찾기")
    void findBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
//            System.out.println("bean : "+bean);
            System.out.println("bean = " + bean);
        }
    }
    @Test
    @DisplayName("빈 찾기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // ROLE_APPLICATION : 스프링이 기본적으로 적용해는 Bean 을 제외한 나머지 (라이브러리, 개발자가 직접 생성한 빈 등)
            // ROLE_INFRASTRUCTURE : 스프링이 내부적으로 사용하는 Bean
            if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName +"/ bean = " + bean);
            }
        }
    }
}
