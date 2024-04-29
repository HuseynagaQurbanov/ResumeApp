package com.main;

import com.dao.impl.CountryDaoImpl;
import com.dao.impl.EmploymentHistoryDaoImpl;
import com.dao.impl.SkillDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.dao.impl.UserSkillDaoImpl;
import com.dao.inter.CountryDaoInter;
import com.dao.inter.EmploymentHistoryDaoInter;
import com.dao.inter.SkillDaoInter;
import com.dao.inter.UserDaoInter;
import com.dao.inter.UserSkillDaoInter;

public class Context {
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl();
    }
    
    public static UserSkillDaoInter instanceUserSkillDao(){
        return new UserSkillDaoImpl();
    }
    
    public static EmploymentHistoryDaoInter instanceEmploymentHistoryDao(){
        return new EmploymentHistoryDaoImpl();
    }
    
    public static CountryDaoInter instanceCountryDao(){
        return new CountryDaoImpl();
    }
    
    public static SkillDaoInter instanceSkillDao(){
        return new SkillDaoImpl();
    }
}
