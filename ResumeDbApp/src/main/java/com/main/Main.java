package com.main;

import com.entity.Country;
import com.entity.User;
import com.dao.inter.UserDaoInter;

public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter userDao = Context.instanceUserDao();

        System.out.println(userDao.getAllSkillByUserId(1));
    }
}
