package com.main;

import com.dao.inter.EmploymentHistoryDaoInter;
import com.entity.EmploymentHistory;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        EmploymentHistoryDaoInter dao = Context.instanceEmploymentHistoryDao();

        System.out.println(dao.getUserAllEmploymentHistoryByUserId(1));

    }
}
