package com.server.dosopt.seminar.sample;

import lombok.Builder;

@Builder
public class Person {
    String firstname;
    String lastname;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
