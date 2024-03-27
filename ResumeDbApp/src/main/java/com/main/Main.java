package com.main;

import com.dao.inter.CountryDaoInter;

public class Main {

    public static void main(String[] args) throws Exception {
        CountryDaoInter userDao = Context.instanceCountryDao();

        System.out.println(userDao.getAllCountry());
    }
}
