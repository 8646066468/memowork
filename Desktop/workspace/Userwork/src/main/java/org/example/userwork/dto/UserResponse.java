package org.example.userwork.dto;

import lombok.Getter;

@Getter
public class UserResponse {
    private final Long id;
    private final String name;
    private final String email;
    private final int age;

    public UserResponse(Long id, String name, String email,int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;

    }

}
