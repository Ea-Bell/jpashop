package jpabook.jpashop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

/**
 * MemberService
 */

/** JPA의 데이터 변경은 트랜잭션 안에서만 변경을 해야한다. */
/**
 * 트랜잭션은 부분적으로 때에는 @Transactional을 걸어주고 중복되는건 따로 하자 아예 함수들이 트랜잭션이 따로 작동할때는 각
 * 함수들이 필요한 트랜잭션 옵션을 주자.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    /**
     * 잊지말자 생성자로 데이터를 주입해야 한다. 그리고 @RequiredArgsConstructor이걸쓰면 final로된 변수들을 자동으로
     * 생성자함수를 만들어준다.
     **/
    private final MemberRepository memberRepository;

    // 회원가입

    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findByName = memberRepository.findByName(member.getName());
        if (!findByName.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}