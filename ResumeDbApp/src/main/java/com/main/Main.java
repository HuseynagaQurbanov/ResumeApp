package com.main;

import com.bean.User;
import com.dao.impl.UserDaoImpl;
import com.dao.inter.UserDaoInter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter userDao = Context.instanceUserDao();
        
        userDao.removeUser(6);
        System.out.println(userDao.getAll());
        
    }
}
