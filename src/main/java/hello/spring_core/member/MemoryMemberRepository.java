package hello.spring_core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
//DB는 확정이 되지 않았지만 임시로 메모리 회원 저장소를 구현하여 개발진행
@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
    return store.get(memberId);
    }

}
