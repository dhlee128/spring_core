package hello.spring_core;

import hello.spring_core.discount.*;
import hello.spring_core.member.MemberRepository;
import hello.spring_core.member.MemberService;
import hello.spring_core.member.MemberServiceImpl;
import hello.spring_core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {// 스프링 컨테이너는 설정정보를 참고하여 의존관계를 주입

    @Bean//@Bean(name="memberService2") 빈 이름 지정 가능
    public MemberService memberService() {// memberRepository()를 의존
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
