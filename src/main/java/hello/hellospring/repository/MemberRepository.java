package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원을 저장하면 저장된 회원이 반환
    Optional<Member> findById(Long id); //id로 회원을 찾는
    Optional<Member> findByName(String name); //optional은 null처리를 위함
    List<Member> findAll(); // 회원의 모든 리스트
}
