package com.company.dao.inter;

import com.company.entity.EmploymentHistory;
import java.util.List;

public interface EmploymentHistoryDaoInter {
    
    List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);
    
    EmploymentHistory getById(int id);
    
    boolean updateEmploymentHistory(EmploymentHistory eh);
    
    boolean removeEmploymentHistory(int id);
    
    boolean addEmploymentHistory(EmploymentHistory eh);
    
    List<EmploymentHistory> getUserAllEmploymentHistoryByUserId(int userId);
}
