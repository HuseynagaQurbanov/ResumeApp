package com.dao.inter;

import com.entity.EmploymentHistory;
import java.util.List;

public interface EmploymentHistoryDaoInter {
    
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);
}
