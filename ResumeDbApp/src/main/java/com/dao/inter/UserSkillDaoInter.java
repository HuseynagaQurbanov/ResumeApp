package com.dao.inter;

import com.entity.User;
import com.entity.UserSkill;
import java.util.List;

public interface UserSkillDaoInter {
    
    public List<UserSkill> getAllSkillByUserId(int userId);
}
