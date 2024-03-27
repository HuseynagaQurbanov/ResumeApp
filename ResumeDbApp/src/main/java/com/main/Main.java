package com.main;

import com.dao.inter.EmploymentHistoryDaoInter;

public class Main {

    public static void main(String[] args) throws Exception {
        EmploymentHistoryDaoInter userDao = Context.EmploymentHistoryDao();

        System.out.println(userDao.getAllEmploymentHistoryByUserId(1));
    }
}
