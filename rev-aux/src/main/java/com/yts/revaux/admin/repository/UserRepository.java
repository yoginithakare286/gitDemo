package com.yts.revaux.admin.repository;

import com.yts.revaux.admin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
//7th change
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
