package com.example.springbasic.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/** scope
 *  singleton, prototype 차이점
 *  singleton 은 AnnotationConfigApplicationContext 클래스를 등록시 초기화를 바로 해주지만
 *  prototype 은 AnnotationConfigApplicationContext 클래스를 등록하더라도 해당 빈을 조회하기 전까지 초기화를 하지 않는다.
 *
 *  싱글톤 빈은  스프링 컨테이너이너 생성 시점에 초기화 메서드가 실행 되지만. 프로토타입 스코프의 빈은 빈을 조회 할때 생성한다
 *
 *  프로토 타입 빈을 두번 조회하면 초기화도 두번 실행되는것을 알 수 있다. (싱글톤은 컨테이너 생성 시점에서 한번만 실행됨 두번 조회 한다고 더 생성되지 않고 기존의 빈을 사용함)
 *  프로토 타입은 생성과 의존관계 주입 초기화에만 관여하고 종료에는 관여하지 않아서 종료 메서드인(@PreDestroy) 가 실행되지 않는다.
 */
public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        // AnnotationConfigApplicationContext 으로 클래스를 등록하면 @Component 가 없어도 자동으로 등록해 준다.
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);


        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        ac.close();

    }

    @Scope("prototype")
    static class PrototypeBean {

        @PostConstruct
        public void init() {
            System.out.println("singletonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("singletonBean.close");
        }

    }
}
