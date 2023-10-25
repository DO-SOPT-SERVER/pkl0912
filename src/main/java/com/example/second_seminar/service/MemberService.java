package com.example.second_seminar.service;

import com.example.second_seminar.MemberJpaRepository;
import com.example.second_seminar.domain.Member;
import com.example.second_seminar.domain.SOPT;
import com.example.second_seminar.dto.request.MemberCreateRequest;
import com.example.second_seminar.dto.request.MemberProfileUpdateRequest;
import com.example.second_seminar.dto.response.MemberGetResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public MemberGetResponse getMemberByIdV1(Long id){
        Member member = memberJpaRepository.findById(id).get();
        return MemberGetResponse.of(member);
    }

    public MemberGetResponse getMemberByIdV2(Long id){
        return MemberGetResponse.of(memberJpaRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("존재하지 않는 회원입니다"))
        );

    }

    public MemberGetResponse getMemberByIdV3(Long id){
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(id));
    }

    public List<MemberGetResponse> getMembers(){
        return memberJpaRepository.findAll()
                .stream()
                .map(MemberGetResponse::of)
                .collect(Collectors.toList());



    }

    @Transactional
    public String create(MemberCreateRequest request){
        Member member = memberJpaRepository.save(Member.builder()
                .name(request.getName())
                .nickname(request.getNickname())
                .age(request.getAge())
                .sopt(request.getSopt())
                .build());
        return member.getId().toString();


    }

    //수정
    @Transactional
    public void updateSOPT(Long memberId, MemberProfileUpdateRequest request) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        member.getSopt().updateSopt(request.getGeneration(), request.getPart());
        memberJpaRepository.save(member);
    }

    //삭제
    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        memberJpaRepository.delete(member);
    }




}
