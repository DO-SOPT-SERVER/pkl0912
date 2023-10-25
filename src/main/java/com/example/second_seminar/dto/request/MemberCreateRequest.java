package com.example.second_seminar.dto.request;

import com.example.second_seminar.domain.SOPT;
import lombok.Data;

@Data
public class MemberCreateRequest {
    private String name;
    private String nickname;
    private int age;
    private SOPT sopt;


}
