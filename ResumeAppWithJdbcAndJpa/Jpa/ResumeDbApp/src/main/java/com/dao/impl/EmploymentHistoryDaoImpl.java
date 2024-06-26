package com.dao.impl;

import com.dao.inter.AbstractDao;
import com.dao.inter.EmploymentHistoryDaoInter;
import com.entity.EmploymentHistory;
import com.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDao implements EmploymentHistoryDaoInter {

    private EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String header = rs.getString("header");
        String jobDescription = rs.getString("job_description");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        int userId = rs.getInt("user_id");

        return new EmploymentHistory(id, header, beginDate, endDate, jobDescription, new User(userId));
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
                EmploymentHistory u = getEmploymentHistory(rs);
                res.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    @Override
    public EmploymentHistory getById(int id) {
        EmploymentHistory res = null;

        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from employment_history where id=" + id);
            ResultSet rs = stmt.getResultSet();

            while(rs.next()){
                res = getEmploymentHistory(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
    public List<EmploymentHistory> getUserAllEmploymentHistoryByUserId(int userId) {
        List<EmploymentHistory> res = new ArrayList();

        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from employment_history where user_id = " + userId);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                res.add(getEmploymentHistory(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory eh) {
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("update employment_history set header = ?, begin_date = ?, end_date = ?, job_description = ?, user_id = ? where id = ?");
            pstmt.setString(1, eh.getHeader());
            pstmt.setDate(2, (Date) eh.getBeginDate());
            pstmt.setDate(3, (Date) eh.getEndDate());
            pstmt.setString(4, eh.getJobDescription());
            pstmt.setInt(5, eh.getUser().getId());
            pstmt.setInt(6, eh.getId());

            return pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeEmploymentHistory(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from employment_history where id = " + id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addEmploymentHistory(EmploymentHistory eh) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert employment_history (header, begin_date, end_date, job_description, user_id) values (?,?,?,?,?)");
            stmt.setString(1, eh.getHeader());
            stmt.setDate(2, (Date) eh.getBeginDate());
            stmt.setDate(3, (Date) eh.getEndDate());
            stmt.setString(4, eh.getJobDescription());
            stmt.setInt(5, eh.getUser().getId());

            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}