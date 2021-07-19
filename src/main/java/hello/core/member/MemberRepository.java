package hello.core.member;

/*
인터페이스 개념
어떤 행위를 할 때 미리 사전에 어떤 작업을 할 건지 만들어놓는 작업
만들어 놓으면 구현체(실행자) -> 인터페이스 호출
인터페이스 정의된 사전 내에서 동작
*/

public interface MemberRepository {
    //회원 저장
    void save(Member member);
    //회원 아이디 찾기
    Member findById(Long memberId);
}
