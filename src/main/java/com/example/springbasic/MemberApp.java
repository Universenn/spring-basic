package com.example.springbasic;

import com.example.springbasic.member.Grade;
import com.example.springbasic.member.Member;
import com.example.springbasic.member.MemberService;
import com.example.springbasic.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        Member member1 = new Member(1L, "juwan", Grade.BASIC);
        Member member2 = new Member(2L, "yeezi", Grade.VIP);

        MemberService memberService = new MemberServiceImpl();
//        Member before = memberService.findMember(2L);
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
