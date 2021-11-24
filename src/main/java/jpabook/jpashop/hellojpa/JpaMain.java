package jpabook.jpashop.hellojpa;

import java.util.List;

import javax.persistence.*;

public class JpaMain { // 엔티티 매니저 팩토리 생성
    private static List<Member2> resultList;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        // code
        try {
            // Member2 member2 = new Member2();
            // member2.setId(2L);
            // member2.setName("helloB");
            // em.persist(member2);
            // Member2 findMember = em.find(Member2.class, 1L);
            // System.out.println("findmember.id = " + findMember.getId());
            // System.out.println("findmember.name = " + findMember.getName());
            // em.remove(findMember); //삭제
            // findMember.setName("HelloJPA"); //수정
            /**
             * JPQL
             */
            // List<Member2> result = em.createQuery("select m from Member2 as m",
            // Member2.class).getResultList();

            // for (Member2 member : result) {
            // System.out.println("member.name = " + member.getName());
            // }

            // // 비영속
            // Member2 member2 = new Member2();
            // member2.setId(101L);
            // member2.setName("HelloJAP");

            // 영속
            // System.out.println("=== Before ===");
            // em.persist(member2);
            // System.out.println("=== after ===");
            // Member2 findMember1 = em.find(Member2.class, 101L);
            // Member2 findMember2 = em.find(Member2.class, 101L);
            // System.out.println("result = " + (findMember1 == findMember2));
            // Member2 member1 = new Member2(150L, "A");
            // Member2 member2 = new Member2(160L, "B");

            // em.persist(member1);
            // em.persist(member2);
            // System.out.println("===============");
            // System.out.println("findMember.id = " + findMember.getId());
            // System.out.println("findMember.name = " + findMember.getName());
            Member2 member = em.find(Member2.class, 150L);
            member.setName("zzzzz");
            tx.commit();
        } catch (

        Exception e) {

        } finally {
            em.close();
        }
        emf.close();
    }
}
