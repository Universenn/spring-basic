package com.example.springbasic.member;

import com.example.springbasic.AppConfig;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member1 = new Member(1L, "juwan", Grade.BASIC);
        Member member2 = new Member(2L, "yeezi", Grade.VIP);

        memberService.join(member1);
        memberService.join(member2);
        Member after = memberService.findMember(2L);

//        nullpoint exception
//        System.out.println(before.getId());
//        System.out.println(before.getName());
//        System.out.println(before.getGrade());


        System.out.println(after.getId());
        System.out.println(after.getName());
        System.out.println(after.getGrade());
    }
}
