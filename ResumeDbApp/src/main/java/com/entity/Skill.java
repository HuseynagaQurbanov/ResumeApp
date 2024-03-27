package com.entity;

import lombok.Data;

@Data
public class Skill {
   private int id;
   private String name;

    public Skill() {
    }

    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
