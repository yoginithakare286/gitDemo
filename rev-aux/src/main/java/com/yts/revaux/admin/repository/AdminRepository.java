package com.yts.revaux.admin.repository;

import com.yts.revaux.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
}
