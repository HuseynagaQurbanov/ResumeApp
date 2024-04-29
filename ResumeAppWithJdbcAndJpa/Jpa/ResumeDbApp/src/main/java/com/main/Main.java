package com.main;

import com.dao.inter.UserDaoInter;
import com.entity.User;

public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter userDao = Context.instanceUserDao();
        
        User u = userDao.getById(1);
        
        System.out.println(u.getEmail());
    }
}
