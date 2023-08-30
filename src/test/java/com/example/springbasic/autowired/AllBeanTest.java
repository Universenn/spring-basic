package com.example.springbasic.autowired;

import com.example.springbasic.AutoAppConfig;
import com.example.springbasic.discount.DiscountPolicy;
import com.example.springbasic.member.Grade;
import com.example.springbasic.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,     DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "juwan", Grade.VIP);

        int discountPolicy = discountService.discount(member, 10000, "fixDiscountPolicy");
        Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(discountPolicy).isEqualTo(1000);
        int discountPolicy2 = discountService.discount(member, 20000, "rateDiscountPolicy");
        Assertions.assertThat(discountPolicy2).isEqualTo(2000);
    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String fixDiscountPolicy) {
            DiscountPolicy discountPolicy = policyMap.get(fixDiscountPolicy);
            return discountPolicy.discount(member, price);
        }
    }
}
