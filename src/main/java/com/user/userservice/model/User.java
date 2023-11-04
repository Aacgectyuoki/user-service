package com.user.userservice.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "name",length = 20)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "about")
    private String about;



}
