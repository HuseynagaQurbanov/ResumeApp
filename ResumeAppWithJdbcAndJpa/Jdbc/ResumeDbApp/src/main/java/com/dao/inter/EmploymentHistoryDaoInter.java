package com.dao.inter;

import com.entity.EmploymentHistory;
import java.util.List;

public interface EmploymentHistoryDaoInter {
    
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);
    
    public EmploymentHistory getById(int id);
    
    boolean updateEmploymentHistory(EmploymentHistory eh);
    
    boolean removeEmploymentHistory(int id);
    
    public boolean addEmploymentHistory(EmploymentHistory eh);
    
        public List<EmploymentHistory> getUserAllEmploymentHistoryByUserId(int userId);
}
