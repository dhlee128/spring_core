package hello.spring_core.discount;

import hello.spring_core.anotation.MainDiscountPolicy;
import hello.spring_core.member.Member;
import hello.spring_core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//회원 정보를 조회 -> 할인 정책을 적용한 주문 객체 반환
@Component
public class OrderServiceImpl implements OrderService {

    //회원 저장소
    private final MemberRepository memberRepository;
    //할인 정책
    private final DiscountPolicy discountPolicy;

    //생성자 주입(외부에서 구현체를 주입) @RequiredArgsConstructor 사용
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);//회원 찾기
        int discountPrice = discountPolicy.discount(member, itemPrice);//해당 회원 할인 금액

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}



