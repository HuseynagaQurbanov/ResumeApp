package com.dao.inter;

import com.entity.User;
import com.entity.UserSkill;
import java.util.List;

public interface UserSkillDaoInter {
    
    public List<UserSkill> getAllSkillByUserId(int userId);
    
    public boolean addUserSkill(UserSkill skill);
    
    public boolean updateUserSkill(UserSkill skill);
    
    public boolean removeUserSkill(int id);
}
