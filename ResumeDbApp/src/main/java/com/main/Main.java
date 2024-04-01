package com.main;

import com.dao.inter.SkillDaoInter;
import com.entity.Skill;

public class Main {

    public static void main(String[] args) throws Exception {
        SkillDaoInter skillDao = Context.instanceSkillDao();
        
       skillDao.removeSkill(10);
    }
}
