package hello.spring_core.discount;

import hello.spring_core.member.Grade;
import hello.spring_core.member.Member;
//VIP 회원만 천원 할인(Fix)
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }

}