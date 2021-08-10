package hello.core.singleton;

import hello.core.APPConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        
        APPConfig appConfig = new APPConfig();
        
        //1.조회 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2.조회 :호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService1 = " + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singetoneServiceTest(){
       // SingletonService singletonService1 = new SingletonService();
       // SingletonService singletonService2 = new SingletonService();
        SingletonService singletonService1= SingletonService.getInstance();
        SingletonService singletonService2= SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("싱글톤 컨테이너 분석")
    void springContainer() {
        //bean 싱글톤 객체 반환
        ApplicationContext ac = new AnnotationConfigApplicationContext(APPConfig.class);

        MemberService memberService1 = ac.getBean("memberService",MemberService.class);
        MemberService memberService2 = ac.getBean("memberService",MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService1 = " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
