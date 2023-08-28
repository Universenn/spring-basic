package com.example.springbasic.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {


    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        // ThreadA: A사용자 10000원 주문
        int userA = statefulService1.order("userA", 10000);
        // ThreadB: B사용자 10000원 주문
        int userB = statefulService2.order("userB", 20000);

        System.out.println("userA = " + userA);
        System.out.println("userB = " + userB);

//        Assertions.assertThat(statefulService1).isEqualTo(20000);

    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }


}