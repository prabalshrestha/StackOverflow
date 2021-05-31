package com.et.stackoverflow.repository;

import com.et.stackoverflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.userName = :username")
    public User getUserByUserName(@Param("username") String username);

    User findByUserName(String userName);

    User findByEmail(String email);

    User findByUserId(Integer userId);
}
