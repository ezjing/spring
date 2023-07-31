package com.bitc.securityquiz.service;

import com.bitc.securityquiz.data.dto.AddMemberRequest;
import com.bitc.securityquiz.data.entity.Member;
import com.bitc.securityquiz.data.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String save(AddMemberRequest dto) {
        return memberRepository.save(Member.builder()
                .id(dto.getId())
                .pass(bCryptPasswordEncoder.encode(dto.getPass()))
                .name(dto.getName())
                .regidate(dto.getRegidate())    // 생성날짜 자동입력 + 낫널때문에 필요
                .grade(1)  // 낫널은 문제없는데 기본값 1때문에 필요, columnDefinition = "integer default 1"이 안통하는데 물어보기
                .build()).getId();  // getId는 왜 있는것이지(리턴 값이다. 나중에쓰려고 가져온거같음)
    }
}
