package hello.spring_core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    //생성자 주입(외부에서 구현체를 주입)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //회원 가입
    public void join(Member member) {
        memberRepository.save(member);
    }
    //회원 조회
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}

