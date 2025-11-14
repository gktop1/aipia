package com.example.aipia.member.service;

import com.example.aipia.common.exception.CustomException;
import com.example.aipia.member.dto.MemberDto;
import com.example.aipia.member.model.MemberEntity;
import com.example.aipia.member.dto.MemberRegisterRequest;
import com.example.aipia.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void registerMember(MemberRegisterRequest memberRegisterRequest) {
        MemberEntity memberEntity = new MemberEntity(memberRegisterRequest);
        memberRepository.save(memberEntity);
    }

    @Transactional(rollbackFor = CustomException.class)
    public MemberDto loginMember(String loginId, String password) throws CustomException {
        MemberEntity member = memberRepository.findMemberEntityByLoginIdAndPassword(loginId, password).orElseThrow(() -> new CustomException("아이디 혹은 비밀번호를 확인해주세요."));
        member.updateLastLoginTime();
        return MemberDto.toDto(member);
    }

    public MemberEntity getMemberEntity(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new CustomException("존재 하지 않는 Member입니다."));
    }
}
