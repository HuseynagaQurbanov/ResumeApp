package com.dao.impl;

import com.entity.Country;
import com.dao.inter.AbstractDao;
import com.dao.inter.SkillDaoInter;
import com.entity.Skill;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;

public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {

    @SneakyThrows
    private Skill getSkill(ResultSet rs){
        int id = rs.getInt("id");
        String name = rs.getString("name");

        return new Skill(id, name);
    }
    
    @Override
    public List<Skill> getAllSkill() {
        List<Skill> res = new ArrayList<>();

        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from skill");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Skill u = getSkill(rs);

                res.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }
}
