package com.example.second_seminar.dto.request;

import com.example.second_seminar.domain.Part;
import lombok.Data;

@Data
public class MemberProfileUpdateRequest {
    private int generation;
    private Part part;
}
