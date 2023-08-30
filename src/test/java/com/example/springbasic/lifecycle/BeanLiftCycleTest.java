package com.example.springbasic.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLiftCycleTest {

    @Test
    void liftCycleTest() {
        // 서버를 닫아 줘야해서. ConfigurableApplicationContext이 인터페이스를 선택해줘야 한다.
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LiftCycleConfig.class);
        NetworkClient networkClient = ac.getBean("networkClient", NetworkClient.class);

        // 서버는 닫아 줘야한다.
        ac.close();
    }

    @Configuration
    static class LiftCycleConfig{

        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
