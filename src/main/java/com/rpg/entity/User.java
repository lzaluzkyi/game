package com.rpg.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "player")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
