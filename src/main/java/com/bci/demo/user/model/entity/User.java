package com.bci.demo.user.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String email;
    private String password;
    private Date created;
    private Date modified;

    @Column(name = "last_login")
    private Date lastLogin;
    private String token;
    private Boolean active;

}
