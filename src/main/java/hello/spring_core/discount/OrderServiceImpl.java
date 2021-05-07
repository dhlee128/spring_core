package hello.spring_core.discount;

import hello.spring_core.member.Member;
import hello.spring_core.member.MemberRepository;
import hello.spring_core.member.MemoryMemberRepository;
//회원 정보를 조회 -> 할인 정책을 적용한 주문 객체 반환
public class OrderServiceImpl implements OrderService {

    //회원 저장소
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //할인 정책
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
