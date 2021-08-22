package hello.core.member;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
구현체(호출자) -> 인터페이스 선언
MemberRepository 인터페이스를선언해놓은 save,findById 함수를 호출해서 사용하지않고
부모(구현체) -> 자식(인터페이스) 오버라이드해서 재정의를 한다.
###체크!!
 */

import java.util.HashMap;

@Component
public class MemoryMemberRepository implements MemberRepository{

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
