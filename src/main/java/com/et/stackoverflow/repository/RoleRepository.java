package com.et.stackoverflow.repository;

import com.et.stackoverflow.model.Security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

}
