package com.example.second_seminar.controller;


import com.example.second_seminar.dto.request.MemberCreateRequest;
import com.example.second_seminar.dto.request.MemberProfileUpdateRequest;
import com.example.second_seminar.dto.response.MemberGetResponse;
import com.example.second_seminar.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberGetResponse> getMemberProfileV1(@PathVariable Long memberId){
        return ResponseEntity.ok(memberService.getMemberByIdV2(memberId));
    }

    @GetMapping(value = "/{memberId}/v2", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<MemberGetResponse> getMemberProfileV2(@PathVariable Long memberId){
        return ResponseEntity.ok(memberService.getMemberByIdV2(memberId));
    }


    //success 메시지 뜨게 하기
    @PostMapping
    public ResponseEntity<String> createMember(@RequestBody MemberCreateRequest request){
        URI location = URI.create(memberService.create(request));
        return ResponseEntity.created(location).body("success");
    }

    @GetMapping
    public ResponseEntity<List<MemberGetResponse>> getMembersProfile(){
        return ResponseEntity.ok(memberService.getMembers());
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> updateMemberSoptInfo(@PathVariable Long memberId, @RequestBody MemberProfileUpdateRequest request){
        memberService.updateSOPT(memberId, request);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMember(@PathVariable Long memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }



}
