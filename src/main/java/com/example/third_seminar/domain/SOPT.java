package com.example.third_seminar.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.STRING;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SOPT {
    private int generation;

    @Enumerated(value = STRING)
    private Part part;

    public void updateSopt(int generation, Part part) {
        this.generation = generation;
        this.part = part;
    }
}
