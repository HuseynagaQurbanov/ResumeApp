package com.dao.impl;

import com.dao.inter.AbstractDao;
import com.dao.inter.EmploymentHistoryDaoInter;
import com.entity.EmploymentHistory;
import com.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDao implements EmploymentHistoryDaoInter {

    private EmploymentHistory getUserEmploymentHistory(ResultSet rs) throws Exception{
        String header = rs.getString("header");
        String jobDescription = rs.getString("job_description");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        int userId = rs.getInt("user_id");
        
        return new EmploymentHistory(null, header, beginDate, endDate, jobDescription, new User(userId));
    }
    
    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        List<EmploymentHistory> res = new ArrayList<>();

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from employment_history where user_id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                EmploymentHistory u = getUserEmploymentHistory(rs);
                res.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

}
