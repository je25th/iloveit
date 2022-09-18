package com.iloveit.service;

import com.iloveit.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    void sign_up() {
        //given
        Member member = new Member("이름", "email");

        //when
        Long saveId = memberService.signup(member);
        Member findMember = memberService.findMember(saveId);
        //signup과 findMember 둘이 다른 트랜젝션이어서 member와 findMember가 다름

        //then
        Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
        Assertions.assertThat(member.getEmail()).isEqualTo(findMember.getEmail());
    }
}