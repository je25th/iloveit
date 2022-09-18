package com.iloveit.member;

import com.iloveit.entity.Member;
import com.iloveit.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = false)
    public Long signup(Member member) {
        return memberRepository.save(member).getId();
    }

    public Member findMember(Long id) {
        return memberRepository.findById(id).orElseThrow();
    }
}
