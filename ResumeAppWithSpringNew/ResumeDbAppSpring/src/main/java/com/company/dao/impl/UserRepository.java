package com.company.dao.impl;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    User findByName(String name);
    User findByNameAndSurname(String name, String surname);

    @Query(value = "select u from User u where u.email = ?1")
    User findByEmail(String email);
}
