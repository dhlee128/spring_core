package hello.spring_core;

import hello.spring_core.discount.Order;
import hello.spring_core.discount.OrderService;
import hello.spring_core.discount.OrderServiceImpl;
import hello.spring_core.member.Grade;
import hello.spring_core.member.Member;
import hello.spring_core.member.MemberService;
import hello.spring_core.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
