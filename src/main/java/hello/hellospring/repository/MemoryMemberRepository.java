package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //Map의 key는 Id value는 Member
    private static long sequence=0L; // 0,1,2.. key값을 생성해주는

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //setId할 때 sequence값을 하나 올려줄 것임
        store.put(member.getId(),member); //store에 저장을 할 것
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //store에 꺼내서 결과를 get. null이 반환 될 수 있으니 Optional으로 감싼다
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //파라미터로 넘어온 name과 같은지 확인
                .findAny(); //루프를 돌면서 찾으면 바로 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store의 맴버들을 반환
    }

    public void clearStore(){
        store.clear();
    }
}
