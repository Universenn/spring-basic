## 스프링

### 무언가를 의존한다. 알고 있다는 뜻
### 단위 테스트가 중요하다 순수한 자바로 테스트하는 것이 중요하다.!!

<details>
<summary>다형성</summary>
<div markdown="1">
- 유연하고 변경에 용의하다.

1) 다형성 본질
    2) 클라이언트를 변경하지 않고, 서버의 기능을 유연하게 변경할 수 있다.
1) 역할과 구현을 분리
    2) 클라이언트는 구현대상의 내부 구조를 몰라도 된다, 구현 대상을 바꾸어도 된다. 클라이언트는 대상의 인터페이스만 알면 된다

</div>
</details>

<details>
<summary> 좋은 객체지향 프로그래밍이란</summary>
<div markdown="1">

- 클린 코드로 유명한 로버트 마틴이 좋은 객체 지향 설계 5가지 원칙을 정리
- SRP : 단일 책임 원칙
  - Single responsibility principle
  - 한 클래스는 하나의 책임만 가져야 한다
  - 하나의 책임이라는 것은 모호하다
    - 클 수 있고, 작을 수 있다.
    - 문맥과 상황에 따라 다르다
  - 중요한 기준은 변경이다. 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것
  - ex) UI 변겨으 객체의 생성과 사용을 분리
- OCP : 개방-폐쇄 원칙
  - Open/closed principle
  - 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어여 한다.
  - 확장을 하려면 당연히 코드에 변경도 있는게 아닌가?
  - 다형성을 활용하여
  - 인터페이스를 구현한 새로운 클래슬르 하나 만들어서 새로운 기능을 구현
  - 지금까지 배운 역할과 구현의 분리를 생각해보자
- LSP : 리스코프 치환 원칙
  - Liskov substitution principle
  - 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으으면서 하위타입의 인스턴스로 바꿀수 있어야 한다
  - 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 한다는 것, 다형성을 지원하기 위한 원칙, 인터페이스를 구현한 구현체는 믿고 사용하려면, 이 원칙이 필요하다.
  - 컴파일 성공이 문제가 아닌 인스턴스 규칙의 문제이다
- ISP : 인터페이스 분리 원칙
  - Interface segregation principle
  - 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다
  - ex) 자동차 인터페이스 -> 운전 인터페이스 정비 인터페이스로 분리
  - ex) 사용자 클라이언트 -> 운전자 클라이언트, 정비사 클라이언트로 분리
  - 분리하면 정비 인스턴스 자체가 변혀도 운전자 클라이언트에게 영향을 주지 않음
  - 인터페이스가 명확해지고 대체 가능성이 높아진다.
- DIP : 의존관계 역전 원칙
  - Dependency inversion principle
  - 프로그래머는 "추상화에 의존해야지, 구체화에 의존하면 안된다." 의존성 중입은 이 원칙을 따르는 방법 중 하나다.
  - 쉽게 말해 구현 클래스에 의존하지 말고, 인터페이스의 의존하라는 말이다.
  - 역할에 의존하게 해야 한다. 그래야 구현체 변경에 용의하다. 구현에 의존하면 변경이 아주 어려워 진다.
  - MemberRepository m = new MemoryMemberRepository
  - MemberRepository 라는 인터페이스를 의존하고 있으면서  구현클래스 MemoryMemberRepository 도 의존한다
  - DIP 위반

### 정리
- 객체 지향의 핵심은 다형성
- 다형성 만으로는 쉽게 부품을 갈아 끼우듯이 개발할 수 없다
- 다형성 만으로는 OCP, DIP 를 지킬 수 없다
- 뭔가 더 필요하다
#### 실무 고민
- 하지만 인터페이스를 도입하면 추상화라는 비용이 발생한다.
- 기능을 확장할 가능성이 없다면, 구체 클래스를 직접 사용하고, 향후 꼭 필요할때 리팩토링해서 인터페이스를 도입하는 것도 방법이다.
</div>
</details>

<details>
<summary> IoC란</summary>
<div markdown="1">

### 제어의 역전 IoC(Inversion of Control)
- 기존 프로그램은 구현 객체가 스스로 생성하고, 연결하고, 실행 했다면 AppConfig 가 등장한 이후 구현 객체는 자신의 로직을 실행하는 것만 담당한다. 
- 이렇듯 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것을 제어의 역전(IoC)이라 한다. 

</div>
</details>

<details>
<summary> DI란</summary>
<div markdown="1">

### 의존관계 주입 DI(Dependency Injection)

- 우선 정적인 클래스 의존 관계와, 실행 시점에 결정되는 동적인 의존 관계가 있다.
- 예제에서 import 만 보고 OrderServiceImpl 은 MemberRepository 와 DiscountPolicy 에 의존한다는 것을 알 수 있지만 실제 실행 시점에서 어떤 객체가 실행되는 지는 알 수 없다.
- 실행 시점에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결 되는 것을 의존관계 주입 이라고 한다.
- 의존관계 주입을 사용하면 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를
  쉽게 변경할 수 있다.
</div>
</details>


<details>
<summary> 프레임워크 vs 라이브러리</summary>
<div markdown="1">

- JUnit 처럼 내가 작성한 코드를 제어하고, 대신 실행하는 것을 프레임워크라 한다.
- 내가 직접 제어의 흐름을 담당한다면 그것은 프레임워크가 아니라 라이브러리다

</div>
</details>


<details>
<summary> 싱글톤</summary>
<div markdown="1">

## 웹 애플리케이션과 싱글톤
- 주로 웹 애플리케이션은 동시에 고객들이 요청을 한다.
```java
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 1. 조회: 호출할 때 마다 객체를 생성 하는지?
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회: 호출할 때 마다 객체를 생성 하는지?
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
    }
```
위 와 같은 코드로 호출을 할때 결과값으로
```java
memberService1 = member.MemberServiceImpl@4988d8b8
memberService2 = member.MemberServiceImpl@c0c2f8d
```
서로 다른 객체가 출력 되는것을 볼 수 있다.

그럼 그 호출이 어마어마 할탠데 나중에는 그 트래픽들을 어떻게 감당 할 것인가? 계속해서 객체를 만들어 낼 것인가? 메모리 낭비가 심해서 안된다.

해결방안은 해당 객체가 딱 1개만 생성되고, 공유하도록 설계하면 된다. - 싱글톤 패턴

### 싱글톤 패턴
- 클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴이다.
- 그래서 객체 인스턴스를 2개 이상 생성하지 못하도록 막아야 한다.
  - private 생성자를 사용해서 외부에서 임이로 new 키워드를 사용하지 못하도록 막아야 한다.

```java
public class SingleTonService {

    // 1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingleTonService instance = new SingleTonService();

    // 2. public 으로 열어서 객체 인스턴스가 필요하면 이  static 메서들르 통해서만 조회하도록 허용한다.
    public static SingleTonService getInstance() {
        return instance;
    }

    // 3. 생성자를 private 으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingleTonService() {
    }
}

```
1. static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.
2. 이 객체 인스턴스가 필요하면 오직 getInstance() 메서드를 통해서만 조회할 수 있다. 이 메서드를
   호출하면 항상 같은 인스턴스를 반환한다.
3. 딱 1개의 객체 인스턴스만 존재해야 하므로, 생성자를 private으로 막아서 혹시라도 외부에서 new
   키워드로 객체 인스턴스가 생성되는 것을 막는다.

```java
// Test
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
//        SingleTonService singleTonService = new SingleTonService();
        // 1. 조회: 호출할 때 마다 객체를 생성 하는지?
        SingleTonService instance1 = SingleTonService.getInstance();

        // 2. 조회: 호출할 때 마다 객체를 생성 하는지?
        SingleTonService instance2 = SingleTonService.getInstance();

        // 참조값이 다른 것을 확인
        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);

        // memberService1 != memberService1
        Assertions.assertThat(instance1).isEqualTo(instance2);

    
//instance1 = singleton.SingleTonService@22fcf7ab
//instance2 = singleton.SingleTonService@22fcf7ab

```
### 싱글톤 패턴 문제점
- 싱글톤 패턴을 구현하는 코드 자체가 많이 들어간다.
- 의존관계상 클라이언트가 구체 클래스에 의존한다 - DIP를 위반한다.
- 클라이언트가 구체 클래스에 의존해서 OCP 원칙을 위반할 가능성이 높다.
- 테스트하기 어렵다.
- 내부 속성을 변경하거나 초기화 하기 어렵다.
- private 생성자로 자식 클래스를 만들기 어렵다.
- 결론적으로 유연성이 떨어진다.
- 안티패턴으로 불리기도 한다.

### 스프링을 사용하면 싱글톤 컨테이너를 사용하면서 다양한 문제점을 해결할 수 있다.  

### 싱글톤 컨테이너
```java
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // 1. 조회: 호출할 때 마다 객체를 생성 하는지?
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        // 2. 조회: 호출할 때 마다 객체를 생성 하는지?
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != memberService1 
        Assertions.assertThat(memberService1).isSameAs(memberService2);

    }

//memberService1 = member.MemberServiceImpl@4218500f
//memberService2 = member.MemberServiceImpl@4218500f
```
위 코드와 같이 스프링 컨테이너 (싱글톤 컨테이너) 를 사용하면 고객의 요청이 올 때 마다 생성하는 것이 아니라, 이미 만들어진 객체를 공유해서 효율적으로 재사용 할 수 있다.

### 싱글톤 주의점

- 싱글톤 패턴이든, 스프링 같은 싱글톤 컨테이너를 사용하든, 객체 인스턴스를 하나만 생성해서 공유하는
싱글톤 방식은 여러 클라이언트가 하나의 같은 객체 인스턴스를 공유하기 때문에 싱글톤 객체는 상태를
유지(stateful)하게 설계하면 안된다.
- 진짜 공유필드는 조심해야 한다! 스프링 빈은 항상 무상태(stateless)로 설계하자.!!!

### @Configuration

```
@Configuration
public class AppConfig {

    // memberService 주입
    @Bean
    public MemberService memberService(){
        System.out.println("call - AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call - AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), getDiscountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call - AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
}

```
```java
        MemberServiceImpl memberService1 = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService1 = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
```


- 어찌 됐든 위 코드와 같이 출력을 하면 memberRepository 는 총 3번 이 출력 되어야 한다.
```java
  "call - AppConfig.memberService"
  "call - AppConfig.memberRepository"
  "call - AppConfig.orderService"
  "call - AppConfig.memberRepository"
  "call - AppConfig.memberRepository"
```

- 하지만 memberRepository 는 하나만 출력 되는것을 볼 수 있다.
```java
  "call - AppConfig.memberService"
  "call - AppConfig.memberRepository"
  "call - AppConfig.orderService"
```

- 그 이유는 빈으로 등록 할때 임의의 클래스를 만들고 상속받아 그 임의의 클래스를 스프링 빈으로 등록한 것이다.
- 그리고 그 빈이 등록이 되어 있으면 빈을 반환하고 스프링 빈이 없으면 생성해서 스프링 빈으로 등록하고 반환하는 코드가 동적으로 만들어 진다.



</div>
</details>
