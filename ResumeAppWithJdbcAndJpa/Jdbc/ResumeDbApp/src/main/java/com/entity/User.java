package com.entity;

import java.sql.Date;
import java.util.List;
import lombok.Data;

@Data
public class User {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String profileDesc;
    private String address;
    private Date birthDate;
    private Country birthPlace;
    private Country nationality;
    private String password;

    private List<UserSkill> skills;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, String surname, String email, String phone, String profileDesc, String address, Date birthDate, Country birthPlace, Country nationality, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.profileDesc = profileDesc;
        this.address = address;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.nationality = nationality;
        this.password = password;
    }
}
