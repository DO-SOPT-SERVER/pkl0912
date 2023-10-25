package com.example.second_seminar.dto.response;

import com.example.second_seminar.domain.Member;
import com.example.second_seminar.domain.SOPT;

public record MemberGetResponse (String name,
                                 String nicknamae,
                                 int age,
                                 SOPT soptInfo){
    public static MemberGetResponse of (Member member){
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }

}
