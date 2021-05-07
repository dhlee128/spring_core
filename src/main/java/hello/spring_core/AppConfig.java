package hello.spring_core;

import hello.spring_core.discount.*;
import hello.spring_core.member.MemberRepository;
import hello.spring_core.member.MemberService;
import hello.spring_core.member.MemberServiceImpl;
import hello.spring_core.member.MemoryMemberRepository;

public class AppConfig {

    //메모리 저장소
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    //메모리 저장소 + 정액 할인 정책
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
