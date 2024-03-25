package com.main;

import com.dao.impl.UserDaoImpl;
import com.dao.inter.UserDaoInter;

public class Context {
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl();
    }
}
