package com.example.practice_1;

import com.example.practice_1.repos.MemberRepository;
import com.example.practice_1.repos.MemoryMemberRepository;
import com.example.practice_1.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
