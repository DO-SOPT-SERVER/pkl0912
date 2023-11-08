package com.example.third_seminar.domain;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //필드 중 하나가autoincrement
    private Long id;
    private String name;
    private String nickname;
    private int age;

    @Embedded
    private SOPT sopt;

//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    private final List<Post> posts = new ArrayList<>();
    @Builder
    public Member(String name, String nickname, int age, SOPT sopt){
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.sopt = sopt;

    }

}
