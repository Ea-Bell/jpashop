package jpabook.jpashop.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor // 이걸 쓰면 스프링 부트 jpa에서 생성자를 만들면 @PersistenceContext이걸 잡아준다. 그래서 코드를 간략하게 하기위해서 이걸
                         // 쓰면 해결된다.
public class MemberRepository {

    // @PersistenceContext // JPA의 엔티티의 매니저를 주입 받을 수 있다. ***스프링이 알아서 해줌.
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList(); // 멤버에 대한
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name=:name", Member.class).setParameter("name", name)
                .getResultList();
    }

}
