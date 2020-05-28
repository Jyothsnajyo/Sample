package com.sample.project.repository;

import com.sample.project.model.data.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,String> {
    Users findByEmail(String email);
    Users findByUsername(String username);
}
