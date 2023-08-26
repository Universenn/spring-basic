package com.example.springbasic.order;

import com.example.springbasic.AppConfig;
import com.example.springbasic.member.Grade;
import com.example.springbasic.member.Member;
import com.example.springbasic.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();
    @Test
    void order() {
        // when
        Member member1 = new Member(1L, "juwan", Grade.VIP);
        Member member2 = new Member(2L, "yeezi", Grade.BASIC);
        memberService.join(member1);
        memberService.join(member2);

        Order order1 = orderService.creatOrder(member1.getId(), "itemA", 10000);
        Order order2 = orderService.creatOrder(member2.getId(), "itemB", 10000);
        Assertions.assertThat(order1.getDiscountPrice()).isEqualTo((int) (order1.getItemPrice()*0.1));
        Assertions.assertThat(order1.getItemName()).isEqualTo("itemA");
        Assertions.assertThat(order2.getDiscountPrice()).isEqualTo(0);
        Assertions.assertThat(order2.getItemName()).isEqualTo("itemB");
    }
}
