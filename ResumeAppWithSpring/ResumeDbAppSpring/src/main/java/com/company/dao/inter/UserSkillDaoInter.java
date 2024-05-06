package com.company.dao.inter;

import com.company.entity.User;
import com.company.entity.UserSkill;
import java.util.List;

public interface UserSkillDaoInter {
    
    public List<UserSkill> getAllSkillByUserId(int userId);
    
    public boolean addUserSkill(UserSkill skill);
    
    public boolean updateUserSkill(UserSkill skill);
    
    public boolean removeUserSkill(int id);
}
