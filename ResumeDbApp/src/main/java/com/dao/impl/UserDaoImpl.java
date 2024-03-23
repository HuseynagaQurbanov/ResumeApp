package com.dao.impl;

import com.bean.User;
import com.dao.inter.AbstractDao;
import com.dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    @Override
    public List<User> getAll() {
        List<User> res = new ArrayList<>();

        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from user");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                res.add(new User(id, name, surname, email, phone));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("update user set name = ?, surname = ?, email = ?, phone = ? where id = ?");
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getSurname());
            pstmt.setString(3, u.getEmail());
            pstmt.setString(4, u.getPhone());

            pstmt.setInt(5, u.getId());
            return pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id = " + id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getById(int userId) {
        User res = new User();

        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from user where id =" + userId);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                return new User(id, name, surname, email, phone);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }
}
