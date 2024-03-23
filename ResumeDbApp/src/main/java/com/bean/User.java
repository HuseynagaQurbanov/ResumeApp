package com.bean;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;

    public User(int id, String name, String surname, String email, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone + '}';
    }

    public User() {
    }
    
}
