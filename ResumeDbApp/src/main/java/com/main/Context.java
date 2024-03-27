package com.main;

import com.dao.impl.EmploymentHistoryDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.dao.impl.UserSkillDaoImpl;
import com.dao.inter.EmploymentHistoryDaoInter;
import com.dao.inter.UserDaoInter;
import com.dao.inter.UserSkillDaoInter;

public class Context {
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl();
    }
    
    public static UserSkillDaoInter instanceUserSkillDao(){
        return new UserSkillDaoImpl();
    }
    
    public static EmploymentHistoryDaoInter EmploymentHistoryDao(){
        return new EmploymentHistoryDaoImpl();
    }
}
