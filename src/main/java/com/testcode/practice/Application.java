package com.testcode.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
* @SpringBootApplication 어노테이션은 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을
* 모두 자동으로 설정된다. @SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에
* 이 클래스는 항상 프로젝트의 최상단에 위치해야만 한다.
* */
@EnableJpaAuditing  // JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        // 내장 WAS 실행
        /*
        * 별도로 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것을 말한다.
        * 이렇게 되면 항상 서버에 톰캣을 설치할 필요가 없게 되고, 스프링 부트로 만들어진 Jar 파일로 실행하면 된다.
        * 내장 WAS 사용하는 것을 권장하는 이유는 "언제 어디서나 같은 환경에서 스프링 부트를 배포" 할 수 있기 때문
        * 외장 WAS를 쓰게 되면 모든 서버는 WAS의 종류와 버전, 설정을 일치시켜야만 한다.
        * ==> 서버가 수십대 일 경우 일일히 버전 및 설정을 맞춰줘야 한다.
        * */
        SpringApplication.run(Application.class, args);
    }
}
