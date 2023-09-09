package ru.isshepelev.restsecurity.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Users {
    @Id
    private String id;

    private String username;
    private String password;
}
