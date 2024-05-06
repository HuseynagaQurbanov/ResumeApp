package com.company.dao.inter;

import com.company.entity.Skill;
import java.util.List;

public interface SkillDaoInter {
    
    public List<Skill> getAllSkill();
    
    public Skill getById(int id);
    
    boolean updateSkill(Skill s);
    
    boolean removeSkill(int id);
    
    public boolean addSkill(Skill skll);
}
