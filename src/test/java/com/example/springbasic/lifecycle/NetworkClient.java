package com.example.springbasic.lifecycle;

/**
 *  implements InitializingBean, DisposableBean 단점
 *
 *  스프링의 너무 의존적이다.
 *  오래전 방법이고 지금은 더 나은 방법이 있어서 거의 사용하지 않는다
 *
 * @Bean(initMethod = "init", destroyMethod = "close")
 *
 * 스프링의 의존적이지 않다
 * 코드가 아니라 설정정보를 사용하기 때문에 고칠 수 없는 외부라이브러리에도 초기화 정보, 종료 메서드를 적용할 수 있다.
 * destroyMethod = "" 공란으로 두면 close와 shutdown 이라는 값을 가진 메서드를 찾아 자동으로 호출 해준다.
 *
 */
public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 url " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 시작 시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message = " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close : " + url);
    }



    // 빈생성 -> 의존관계 주입 -> afterPropertiesSet() 호출
    public void init()  {
        connect();
        call("초기화 연결 메시지");
    }

    // 빈이 종료 되기 직전 destroy() 호출
    public void close() {
        disconnect();
    }
}
