package com.dao.impl;

import com.entity.Skill;
import com.entity.User;
import com.entity.UserSkill;
import com.dao.inter.AbstractDao;
import com.dao.inter.UserSkillDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter {

    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        int userSkillId = rs.getInt("userSkillId");
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");

        //return new UserSkill(userSkillId, new User(userId), new Skill(skillId, skillName), power);
        return new UserSkill();
    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> res = new ArrayList<>();

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select "
                    + "us.id as userSkillId, "
                    + "u.*, "
                    + "us.skill_id, "
                    + "s.name as skill_name, "
                    + "us.power "
                    + "from "
                    + "user_skill us "
                    + "left join user u on us.user_id = u.id "
                    + "left join skill s on us.skill_id = s.id "
                    + "where us.user_id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                UserSkill u = getUserSkill(rs);

                res.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean addUserSkill(UserSkill skill) {
        boolean res = true;

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into user_skill (skill_id, user_id, power) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, skill.getSkill().getId());
            stmt.setInt(2, skill.getUser().getId());
            stmt.setInt(3, skill.getPower());

            res = stmt.execute();

            ResultSet generatedKeys = stmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                skill.setId(generatedKeys.getInt(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            res = false;
        }
        
        return res;
    }

    @Override
    public boolean updateUserSkill(UserSkill skill) {
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("update user_skill set user_id = ?, skill_id = ?, power = ? where id = ?");
            pstmt.setInt(1, skill.getUser().getId());
            pstmt.setInt(2, skill.getSkill().getId());
            pstmt.setInt(3, skill.getPower());
            pstmt.setInt(4, skill.getId());

            return pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUserSkill(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user_skill where id = " + id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
