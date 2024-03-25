package com.main;

import com.bean.Country;
import com.bean.User;
import com.dao.inter.UserDaoInter;

public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter userDao = Context.instanceUserDao();
        
        System.out.println(userDao.getById(1));
        
    }
}
