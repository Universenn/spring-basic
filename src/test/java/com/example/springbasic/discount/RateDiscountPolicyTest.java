package com.example.springbasic.discount;

import com.example.springbasic.member.Grade;
import com.example.springbasic.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 실제 할인 확인")
    void vip_o() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        int discount = rateDiscountPolicy.discount(member, 20000);

        // then
        Assertions.assertThat(discount).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP 아닐시 결과")
    void vip_x() {
        // given
        Member member = new Member(1L, "memberA", Grade.BASIC);

        // when
        int discount = rateDiscountPolicy.discount(member, 20000);

        // then
        Assertions.assertThat(discount).isEqualTo(0);
    }

}