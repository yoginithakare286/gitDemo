package com.yts.revaux.admin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yts.revaux.admin.entity.Admin;
import com.yts.revaux.admin.entity.User;
//7th change
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<Admin> findByUsername(String username);
    Optional<User> findByUsernames(String username);
    Optional<User> findByUsernamess(String username);
}
