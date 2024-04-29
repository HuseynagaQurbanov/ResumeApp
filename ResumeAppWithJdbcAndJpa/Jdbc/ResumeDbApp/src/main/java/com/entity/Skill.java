package com.entity;

import lombok.Data;

@Data
public class Skill {

    private int id;
    private String name;

    public Skill() {
    }
    
    public Skill(int id) {
    }

    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
