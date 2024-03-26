package com.dao.inter;

import com.bean.User;
import com.bean.UserSkill;
import java.util.List;

public interface UserDaoInter {
    
    public boolean addUser(User u);
    
    public List<User> getAll();
    
    public User getById(int id);
    
    public boolean updateUser(User u);
    
    public boolean removeUser(int id);
    
    public List<UserSkill> getAllSkillByUserId(int userId);
}
