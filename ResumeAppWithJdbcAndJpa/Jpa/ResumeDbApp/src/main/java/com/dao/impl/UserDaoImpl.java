package com.dao.impl;

import com.entity.User;
import com.dao.inter.AbstractDao;
import com.dao.inter.UserDaoInter;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {


    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        List<User> res = new ArrayList<>();

        try (Connection c = connect()) {


            String sqlQuery = "select "
                    + "*, "
                    + "n.nationality as nationality, "
                    + "c.name as birthplace "
                    + "from user u "
                    + "left join country n on u.nationality_id = n.id "
                    + "left join country c on u.birthplace_id = c.id where 1=1";

            if (name != null && !name.trim().isEmpty()){
                sqlQuery += " and u.name=? ";
            }
            if (surname != null && !surname.trim().isEmpty()){
                sqlQuery += " and u.surname=? ";
            }
            if (nationalityId != null){
                sqlQuery += " and u.nationality_id=? ";
            }

            PreparedStatement stmt = c.prepareStatement(sqlQuery);

            int i=1;
            if (name!=null && !name.trim().isEmpty()){
                stmt.setString(i,name);
                i++;
            }
            if (surname!=null && !surname.trim().isEmpty()){
                stmt.setString(i,surname);
                i++;
            }
            if (nationalityId!=null){
                stmt.setInt(i,nationalityId);
            }

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                //User u = getUser(rs);

                //res.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    @Override
    public User getById(int userId) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("resumeappPU");
        
        EntityManager entityManager = emFactory.createEntityManager();
        
        User u = entityManager.find(User.class, userId);
        
        return u;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("update user set name = ?, surname = ?, email = ?, phone = ?, profile_description = ?, address = ?, birthdate = ?, birthplace_id = ?, nationality_id = ?, password = ? where id = ?");
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getSurname());
            pstmt.setString(3, u.getEmail());
            pstmt.setString(4, u.getPhone());
            pstmt.setString(5, u.getProfileDesc());
            pstmt.setString(6, u.getAddress());
            pstmt.setDate(7, (Date) u.getBirthDate());
            pstmt.setInt(8, u.getBirthPlace().getId());
            pstmt.setInt(9, u.getNationality().getId());
            pstmt.setString(10, u.getPassword());
            pstmt.setInt(11, u.getId());
            
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
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("insert into user(name,surname,email,phone) values(?,?,?,?)");
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getSurname());
            pstmt.setString(3, u.getEmail());
            pstmt.setString(4, u.getPhone());

            return pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @SneakyThrows
    @Override
    public User findUserByEmailAndPassword(String email, String password){
        User result = null;

        Connection c = connect();
        PreparedStatement stmt = c.prepareStatement("select * from user where email=? and password=?");
        stmt.setString(1, email);
        stmt.setString(2,password);

        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            //result = getUserSimple(rs);
        }

        return result;
    }
}
