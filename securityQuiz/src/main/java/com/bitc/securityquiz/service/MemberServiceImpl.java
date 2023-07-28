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
                .grade(dto.getGrade())  // 낫널은 문제없는데 기본값 1때문에 필요
                .build()).getId();
    }
}
