package com.bci.demo.user.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "phone")
@Getter
@Setter
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "city_code")
    private String cityCode;

    private String number;

}
