package com.nour.plantes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nour.plantes.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}
