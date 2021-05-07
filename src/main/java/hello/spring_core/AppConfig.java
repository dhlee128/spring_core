package hello.spring_core;

import hello.spring_core.discount.FixDiscountPolicy;
import hello.spring_core.discount.OrderService;
import hello.spring_core.discount.OrderServiceImpl;
import hello.spring_core.member.MemberService;
import hello.spring_core.member.MemberServiceImpl;
import hello.spring_core.member.MemoryMemberRepository;

public class AppConfig {
    //메모리 저장소
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    //메모리 저장소 + 정액 할인 정책
    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
