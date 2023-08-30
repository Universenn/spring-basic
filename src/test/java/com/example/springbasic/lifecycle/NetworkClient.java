package com.example.springbasic.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

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

    /**
     *  implements InitializingBean, DisposableBean 단점
     *
     *  스프링의 너무 의존적이다.
     *  오래전 방법이고 지금은 더 나은 방법이 있어서 거의 사용하지 않는다
     *
     */


    // 빈생성 -> 의존관계 주입 -> afterPropertiesSet() 호출
    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }

    // 빈이 종료 되기 직전 destroy() 호출
    @Override
    public void destroy() throws Exception {
        disconnect();
    }
}
