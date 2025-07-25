package com.example.login.service;

import com.example.login.entity.Member;
import com.example.login.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository,
                         BCryptPasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 註冊
    public Member register(String username, String password, String email) {
        String encoded = passwordEncoder.encode(password);
        Member member = new Member(username, encoded, email);
        return memberRepository.save(member);
    }
}

