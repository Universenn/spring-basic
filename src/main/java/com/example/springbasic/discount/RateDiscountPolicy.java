package com.example.springbasic.discount;

import com.example.springbasic.annotation.MainDiscountPolicy;
import com.example.springbasic.member.Grade;
import com.example.springbasic.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private final int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
