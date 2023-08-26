package com.example.springbasic.order;

import com.example.springbasic.AppConfig;
import com.example.springbasic.member.Grade;
import com.example.springbasic.member.Member;
import com.example.springbasic.member.MemberService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Member member1 = new Member(1L, "juwan", Grade.BASIC);
        Member member2 = new Member(2L, "yeezi", Grade.VIP);
        memberService.join(member1);
        memberService.join(member2);

        Order order1 = orderService.creatOrder(member1.getId(), "itemA", 20000);
        Order order2 = orderService.creatOrder(member2.getId(), "itemB", 20000);
        System.out.println(order1);
        System.out.println(order2);
    }
}
