package com.dao.inter;

import com.entity.User;
import com.entity.UserSkill;
import java.util.List;

public interface UserDaoInter {
    
    public boolean addUser(User u);
    
    public List<User> getAll();
    
    public User getById(int id);
    
    public boolean updateUser(User u);
    
    public boolean removeUser(int id);
}
