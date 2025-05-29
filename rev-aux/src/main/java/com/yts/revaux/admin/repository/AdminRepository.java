package com.yts.revaux.admin.repository;

import com.yts.revaux.admin.entity.Admin;
import com.yts.revaux.admin.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//6th change
public interface AdminRepository extends JpaRepository<Admin, Long> {
	   Optional<User> findByUsername(String username);
}
