package com.example.springbasic.order;

import com.example.springbasic.member.Grade;
import com.example.springbasic.member.Member;
import com.example.springbasic.member.MemberService;
import com.example.springbasic.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Member member = new Member(1L, "juwan", Grade.BASIC);
        memberService.join(member);

        Order order = orderService.creatOrder(member.getId(), "itemA", 10000);
        System.out.println(order);
    }
}
