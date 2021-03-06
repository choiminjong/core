package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
순수 자바로만 개발
*/

public class MemberApp {

    //pscm + tab
    public static void main(String[] args) {

        /*
        순수 자바로 DI 구현
         */
//      APPConfig appConfig = new APPConfig();
//      MemberService memberService = appConfig.memberService();

        /*
        스프링 DI 구현
         */

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(APPConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+ member.getName());
        System.out.println("finde Member = "+ findMember.getName());

    }
}
