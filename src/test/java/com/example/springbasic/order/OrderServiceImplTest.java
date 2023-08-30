package com.example.springbasic.order;

import com.example.springbasic.discount.FixDiscountPolicy;
import com.example.springbasic.discount.RateDiscountPolicy;
import com.example.springbasic.member.Grade;
import com.example.springbasic.member.Member;
import com.example.springbasic.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L, "juwan", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new FixDiscountPolicy());
        Order order = orderService.creatOrder(1L, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

    @Test
    void createOrder2() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        Member juwan = new Member(1L, "juwan", Grade.VIP);
        Member yeezi = new Member(2L, "yeezi", Grade.BASIC);
        memoryMemberRepository.save(juwan);
        memoryMemberRepository.save(yeezi);

        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new RateDiscountPolicy());
        Order order1 = orderService.creatOrder(juwan.getId(), "itemA", 20000);
        Order order2 = orderService.creatOrder(yeezi.getId(), "itemA", 20000);

        Assertions.assertThat(order1.getDiscountPrice()).isEqualTo(2000);
        Assertions.assertThat(order2.getDiscountPrice()).isEqualTo(0);

    }
}