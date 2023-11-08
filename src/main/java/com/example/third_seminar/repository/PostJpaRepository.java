package com.example.third_seminar.repository;

import com.example.third_seminar.domain.Post;
import com.example.third_seminar.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByMemberId(Long memberId);
    List<Post> findAllByMember(Member member);

}
