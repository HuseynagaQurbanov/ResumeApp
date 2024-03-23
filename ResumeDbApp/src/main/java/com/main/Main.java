package com.main;

import com.bean.User;
import com.dao.impl.UserDaoImpl;
import com.dao.inter.UserDaoInter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter userDao = new UserDaoImpl();
        
        User u = userDao.getById(2);
        u.setName("Musa");
        userDao.updateUser(u);
        System.out.println(userDao.getAll());
        
    }
}
