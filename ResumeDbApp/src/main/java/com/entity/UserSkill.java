package com.entity;

import lombok.Data;

@Data
public class UserSkill {
   private Integer id;
   private User user;
   private Skill skill;
   private int power;

    public UserSkill() {
    }

    public UserSkill(Integer id, User user, Skill skill, int power) {
        this.id = id;
        this.user = user;
        this.skill = skill;
        this.power = power;
    }
}
