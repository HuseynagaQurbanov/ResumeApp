package com.main;

import com.dao.inter.SkillDaoInter;

public class Main {

    public static void main(String[] args) throws Exception {
        SkillDaoInter userDao = Context.instanceSkillDao();

        System.out.println(userDao.getAllSkill());
    }
}
