package com.example.springbasic.order;

import com.example.springbasic.AppConfig;
import com.example.springbasic.member.Grade;
import com.example.springbasic.member.Member;
import com.example.springbasic.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
        // appConfig 에 있는 설정 정보를 스프링 컨테이너에 넣어서 관리를 해준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class); // 1번째 파라미터 Bean 으로 등록된 이름으로 찾는다, 2번째는 반환 타입
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);// 1번째 파라미터로 찾는다, 2번째는 반환 타입

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
