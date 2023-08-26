package com.example.springbasic.member;

import com.example.springbasic.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MemberApp {
    public static void main(String[] args) {
        // appConfig 에 있는 설정 정보를 스프링 컨테이너에 넣어서 관리를 해준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class); // 1번째 파라미터로 찾는다, 2번째는 반환 타입

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
