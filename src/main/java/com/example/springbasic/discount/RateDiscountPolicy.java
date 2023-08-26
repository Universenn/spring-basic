package com.example.springbasic.discount;

import com.example.springbasic.member.Grade;
import com.example.springbasic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private final double RateDiscount = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return (int) (price * (RateDiscount / 100.0));
        }
        return 0;
    }
}
