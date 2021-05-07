package hello.spring_core.member;
//회원을 가입하고 조회할 수 있다.
public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
