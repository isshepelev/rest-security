package ru.isshepelev.restsecurity.entity;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
}
