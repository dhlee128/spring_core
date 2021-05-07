package hello.spring_core.member;
//회원 DB는 미확정->메모리/DB/외부 시스템 연동 회원 저장소 등..
public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
