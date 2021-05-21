package com.et.stackoverflow.repository;

import com.et.stackoverflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String userName);

    User findByEmail(String email);

    User findByUserId(Integer id);
}
