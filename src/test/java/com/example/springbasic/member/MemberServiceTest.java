package com.example.springbasic.member;

import com.example.springbasic.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

    @Test
    void join(){
        // given
        Member member = new Member(1L, "MemberA", Grade.VIP);

        // when
        memberService.join(member);
        Member member1 = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(member1);
    }
}
