package com.example.springbasic.singleton;

import com.example.springbasic.AppConfig;
import com.example.springbasic.member.MemberRepository;
import com.example.springbasic.member.MemberServiceImpl;
import com.example.springbasic.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService1 = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService1 = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        System.out.println("orderService1 = " + orderService1.getMemberRepository());
        System.out.println("memberService1 = " + memberService1.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(memberService1.getMemberRepository()).isSameAs(orderService1.getMemberRepository());
        Assertions.assertThat(memberRepository).isSameAs(orderService1.getMemberRepository());


    }

    @Test
    void name() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean);
    }
}
