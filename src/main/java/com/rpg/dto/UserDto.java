package com.rpg.dto;

import lombok.Data;

@Data
public class UserDto {

    private Integer id;
    private String login;
    private String password;
    private String role;

    public UserDto(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
