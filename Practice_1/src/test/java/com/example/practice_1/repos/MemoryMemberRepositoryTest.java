package com.example.practice_1.repos;

import com.example.practice_1.dto.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repos = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repos.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("sprint");

        repos.save(member);
        Member ret = repos.findById(member.getId()).get();
        assertThat(member).isEqualTo(ret);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repos.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repos.save(member2);

        Member ret = repos.findByName("spring1").get();
        assertThat(ret).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repos.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repos.save(member2);

        List<Member> ret = repos.findAll();
        assertThat(ret.size()).isEqualTo(2);
    }
}
