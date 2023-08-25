package com.example.springbasic.order;


import com.example.springbasic.discount.DiscountPolicy;
import com.example.springbasic.discount.FixDiscountPolicy;
import com.example.springbasic.member.Member;
import com.example.springbasic.member.MemberService;
import com.example.springbasic.member.MemberServiceImpl;

public class OrderServiceImpl implements OrderService {

    private final MemberService memberService = new MemberServiceImpl();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order creatOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberService.findMember(memberId);
        int discount = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discount);
    }
}